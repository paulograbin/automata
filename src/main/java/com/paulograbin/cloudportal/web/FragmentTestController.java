package com.paulograbin.cloudportal.web;

import com.paulograbin.cloudportal.BuildService;
import com.paulograbin.cloudportal.DeploymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("fragmenttt")
public class FragmentTestController {

    private final Logger LOG = LoggerFactory.getLogger(BuildService.class);

    private final BuildService buildService;
    private final DeploymentService deploymentService;

    public FragmentTestController(BuildService buildService, DeploymentService deploymentService) {
        this.buildService = buildService;
        this.deploymentService = deploymentService;
    }

    @GetMapping
    public String createAndDeployBuild() {
        return "fragments/menus.html :: dataPresent";
    }

}
