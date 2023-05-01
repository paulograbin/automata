package com.paulograbin.cloudportal.web;

import com.paulograbin.cloudportal.BuildService;
import com.paulograbin.cloudportal.DeploymentService;
import com.paulograbin.cloudportal.EnvironmentService;
import com.paulograbin.cloudportal.ccv2.dto.BuildDetailsDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailsDTO;
import com.paulograbin.cloudportal.model.AutomataDeploymentDetailsDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;


@Controller
@RequestMapping("/")
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    private final BuildService buildService;
    private final DeploymentService deploymentService;
    private final EnvironmentService environmentService;

    public HomeController(BuildService buildService, DeploymentService deploymentService, EnvironmentService environmentService) {
        this.buildService = buildService;
        this.deploymentService = deploymentService;
        this.environmentService = environmentService;
    }


    @GetMapping
    public String home(Model model) {
        Instant start = Instant.now();

        CompletableFuture<EnvironmentsDTO> environmentsFuture = environmentService.fetchAllEnvironments();
        CompletableFuture<BuildDetailsDTO> last10BuildsFuture = buildService.getLast10Builds();
        CompletableFuture<DeploymentDetailsDTO> deploymentsFuture = deploymentService.fetchCurrentDeployments();
        CompletableFuture<AutomataDeploymentDetailsDTO> pendingDeploymentsFuture = deploymentService.fetchPendingDeployments();

        CompletableFuture.allOf(environmentsFuture, last10BuildsFuture, deploymentsFuture, pendingDeploymentsFuture).join();

        environmentsFuture.thenAccept(e -> model.addAttribute("environments", e));
        last10BuildsFuture.thenAccept(b -> model.addAttribute("builds", b));
        deploymentsFuture.thenAccept(d -> model.addAttribute("deployments", d));
        pendingDeploymentsFuture.thenAccept(d -> model.addAttribute("pendingDeployments", d));

        long l = Duration.between(start, Instant.now()).toMillis();
        LOG.info("Page took {} ms to load", l);
        return "index.html";
    }
}
