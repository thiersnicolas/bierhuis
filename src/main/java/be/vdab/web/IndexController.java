package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BierService;

@Controller
@RequestMapping("/")
public class IndexController {
	private static final String VIEW = "index";
	
	private final BierService bierService;
	
	public IndexController(BierService bierService) {
		this.bierService = bierService;
	}
	
	@GetMapping
	ModelAndView index() {
		return new ModelAndView(VIEW).addObject("aantalBieren", bierService.findAantalBieren());
	}
}
