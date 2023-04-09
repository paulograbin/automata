package com.paulograbin.cloudportal.web;

import com.paulograbin.cloudportal.BuildService;
import com.paulograbin.cloudportal.DeploymentService;
import com.paulograbin.cloudportal.EnvironmentService;
import com.paulograbin.cloudportal.ccv2.dto.BuildDetailsDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailsDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;


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
    public String home(Model model) throws ExecutionException, InterruptedException {
        CompletableFuture<EnvironmentsDTO> environmentsDTOCompletableFuture = environmentService.fetchAllEnvironments();
        CompletableFuture<BuildDetailsDTO> last10BuildsFuture = buildService.getLast10Builds();

        Stream.of(environmentsDTOCompletableFuture, last10BuildsFuture)
                .map(CompletableFuture::join)
                .forEach(l -> LOG.info("Something completed..."));

        last10BuildsFuture.thenAccept(b -> model.addAttribute("builds", b));

        model.addAttribute("environments", environmentService.fetchAllEnvironmentsSync());
        model.addAttribute("deployments", deploymentService.fetchCurrentDeployments().get());

//        model.addAttribute("environments", new EnvironmentsDTO());
//        model.addAttribute("builds", new com.paulograbin.cloudportal.ccv2.dto.BuildDetailsDTO());
//        model.addAttribute("deployments", new DeploymentDetailsDTO());

        return "index.html";
    }
}
