package com.paulograbin.cloudportal.event;

import com.paulograbin.cloudportal.BackupService;
import com.paulograbin.cloudportal.BuildService;
import com.paulograbin.cloudportal.DeploymentService;
import com.paulograbin.cloudportal.ccv2.CloudPortalAPI;
import com.paulograbin.cloudportal.ccv2.MiscService;
import com.paulograbin.cloudportal.ccv2.dto.BuildDetailsDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateBuildResponseDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateDeploymentResponseDTO;
import com.paulograbin.cloudportal.ccv2.dto.DatabackupDetailsDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;
import com.paulograbin.cloudportal.model.AutomataDeploymentDetailDTO;
import com.paulograbin.cloudportal.model.AutomataDeploymentDetailsDTO;
import com.paulograbin.cloudportal.web.ConfigurationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.springframework.util.CollectionUtils.isEmpty;


@Profile("commandline")
@Component
public class CommandLineEventListener implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(CommandLineEventListener.class);

    private final BackupService backupService;
    private final BuildService buildService;
    private final DeploymentService deploymentService;
    private final MiscService miscService;
    private final ConfigurationService configurationService;
    private final CloudPortalAPI cloudPortalAPI;


    public CommandLineEventListener(BackupService backupService, BuildService buildService, DeploymentService deploymentService, MiscService miscService, ConfigurationService configurationService, CloudPortalAPI cloudPortalAPI) {
        this.backupService = backupService;
        this.buildService = buildService;
        this.deploymentService = deploymentService;
        this.miscService = miscService;
        this.configurationService = configurationService;
        this.cloudPortalAPI = cloudPortalAPI;
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Running in command line mode");

        if (args[0].equalsIgnoreCase("monitor")) {
            LOG.info("Will monitor current builds and deployments...");
            monitorCurrentBuildsAndDeployments();

//            tryOldApiCalls();
        } else {
            LOG.info("Will start new build/deployment...");

            String branchName = args[0];
            String environmentCode = args[1];

            if (branchName.isEmpty() || environmentCode.isEmpty()) {
                throw new RuntimeException("Branch name and environment code cannot be empty");
            }

            LOG.info("Branch name {}", branchName);
            LOG.info("Environment code {}", environmentCode);

            CreateBuildResponseDTO createBuildResponse = buildService.createBuild(branchName);
            buildService.monitorBuild(createBuildResponse.getCode());

            LOG.info("Send deployment request");
            CreateDeploymentResponseDTO createDeploymentResponseDTO = deploymentService.makeDeployment(createBuildResponse.getCode(), environmentCode);

            LOG.info("Will start monitoring the deployment");
            deploymentService.monitorDeployment(createDeploymentResponseDTO.getCode());

            System.exit(0);
        }
    }

    private void tryOldApiCalls() {
        miscService.testOldAPI();
    }

    private void monitorCurrentBuildsAndDeployments() {
        CompletableFuture<AutomataDeploymentDetailsDTO> deploymentDetailsDTOCompletableFuture = deploymentService.fetchPendingDeployments();
        CompletableFuture<BuildDetailsDTO> last10BuildsFuture = buildService.getLast10Builds();

        AtomicBoolean waitingForBuildToComplete = new AtomicBoolean(false);
        AtomicBoolean waitingForDeploymentToComplete = new AtomicBoolean(false);

        last10BuildsFuture.thenAccept(builds -> {
            for (var recentBuild : builds.getValue()) {
                if (recentBuild.getStatus().equalsIgnoreCase("BUILDING") || recentBuild.getStatus().equals("UNKNOWN")) {
                    new Thread(() -> {
                        LOG.info("WILL MONITOR BUILD {}", recentBuild.getCode());
                        waitingForBuildToComplete.set(true);
                        buildService.monitorBuild(recentBuild.getCode());
                        waitingForBuildToComplete.set(false);
                    }).start();
                }
            }
        });

        deploymentDetailsDTOCompletableFuture.thenAccept(deployments -> {
            for (AutomataDeploymentDetailDTO deploy : deployments.getValue()) {
                new Thread(() -> {
                    LOG.info("Will monitor deployment {}", deploy.getCode());
                    waitingForDeploymentToComplete.set(true);
                    deploymentService.monitorDeployment(deploy.getCode());
                    waitingForDeploymentToComplete.set(false);
                }).start();
            }
        });

        CompletableFuture.allOf(deploymentDetailsDTOCompletableFuture, last10BuildsFuture).join();

        while (waitingForBuildToComplete.get() || waitingForDeploymentToComplete.get()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

//        System.exit(0);
    }
}
