package com.paulograbin.cloudportal;

import com.paulograbin.ccv2api.model.DeploymentDetailsDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController {

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
        model.addAttribute("environments", environmentService.fetchAllEnvironments());
//        model.addAttribute("environments", new EnvironmentsDTO());

        model.addAttribute("builds", buildService.getAllBuilds());
//        model.addAttribute("builds", new com.paulograbin.ccv2api.model.BuildDetailsDTO());

        model.addAttribute("deployments", deploymentService.fetchDeployments());
//        model.addAttribute("deployments", new DeploymentDetailsDTO());

        return "index.html";
    }
}
