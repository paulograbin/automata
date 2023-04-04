package com.paulograbin.cloudportal.web;

import com.paulograbin.cloudportal.EnvironmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("environments")
public class EnvironmentsController
{
	private final EnvironmentService environmentService;

	public EnvironmentsController(EnvironmentService environmentService)
	{
		this.environmentService = environmentService;
	}

	@GetMapping
	public String getFragment(Model model) {
		model.addAttribute("environments", environmentService.fetchAllEnvironmentsByPassCache());

		return "pieces/environments :: envs";
	}
}
