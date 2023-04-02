package com.paulograbin.cloudportal;

 import com.paulograbin.ccv2api.model.BuildDetailsDTO;
 import com.paulograbin.ccv2api.model.DeploymentDetailsDTO;
 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController
{

	private final BuildService buildService;
	private final DeploymentService deploymentService;

	public HomeController(BuildService buildService, DeploymentService deploymentService)
	{
		this.buildService = buildService;
		this.deploymentService = deploymentService;
	}

	@GetMapping
	public String home(Model model)
	{
		model.addAttribute("aaaa", "adsdasdasdasda");

		BuildDetailsDTO allBuilds = buildService.getAllBuilds();
		model.addAttribute("builds", allBuilds);

		DeploymentDetailsDTO deploymentDetailsDTO = deploymentService.fetchDeployments();
		model.addAttribute("deployments", deploymentDetailsDTO);

		return "index.html";
	}

}
