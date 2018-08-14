package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
public class BrouwerController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	
	private final BrouwerService brouwerService;
	
	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}
	
	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(BROUWERS_VIEW).addObject("brouwers", brouwerService.findAll());
	}
}
