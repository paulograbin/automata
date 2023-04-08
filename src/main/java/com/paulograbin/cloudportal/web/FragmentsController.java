package com.paulograbin.cloudportal.web;

import com.paulograbin.cloudportal.EnvironmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {

    private final EnvironmentService environmentService;

    public FragmentsController(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }


    @GetMapping("/fragments")
    public String getHome(Model model) {
        model.addAttribute("data", environmentService.fetchAllEnvironmentsSync());

        return "fragments.html";
    }
}