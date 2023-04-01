package com.paulograbin.cloudportal;

 import com.paulograbin.ccv2api.model.BuildDetailsDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController
{

	BuildService buildService;

	public HomeController(BuildService buildService)
	{
		this.buildService = buildService;
	}

	@GetMapping
	public String home(Model model)
	{
		model.addAttribute("aaaa", "adsdasdasdasda");

		BuildDetailsDTO allBuilds = buildService.getAllBuilds();
		model.addAttribute("builds", allBuilds);

		return "index.html";
	}

}
