package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
public class BrouwerController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BIEREN_VIEW = "brouwers/bierenvanbrouwer";

	private static final String REDIRECT_URL_BROUWER_NIET_GEVONDEN = "redirect:/brouwers";	
	
	private final BrouwerService brouwerService;
	
	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}
	
	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(BROUWERS_VIEW).addObject("brouwers", brouwerService.findAll());
	}
	
	@GetMapping("vanbrouwer/{brouwer}")
	ModelAndView bierenPerBrouwer(@PathVariable Brouwer brouwer) {
		if (brouwer==null) {
			return new ModelAndView(REDIRECT_URL_BROUWER_NIET_GEVONDEN);
		}
		return new ModelAndView(BIEREN_VIEW)
				.addObject(brouwer);
	}
}
