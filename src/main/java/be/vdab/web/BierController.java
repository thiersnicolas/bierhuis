package be.vdab.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bier;
import be.vdab.valueobjects.Bestelbonlijn;

@Controller
@RequestMapping("/bieren")
@SessionAttributes("bestelbonlijn")
public class BierController {
	private static final String BIER_VIEW = "bieren/bier";

	private static final String REDIRECT_URL_BIER_NIET_GEVONDEN = "redirect:/brouwers";
	private static final String REDIRECT_URL_NA_ADDTOWINKELMAND = "redirect:/winkelmand";

	private final Winkelmand winkelmand;

	public BierController(Winkelmand winkelmand) {
		this.winkelmand = winkelmand;
	}

	@GetMapping("{bier}")
	ModelAndView bier(@PathVariable Bier bier) {
		if (bier==null) {
			return new ModelAndView(REDIRECT_URL_BIER_NIET_GEVONDEN);
		}
		ModelAndView modelAndView = new ModelAndView(BIER_VIEW);
		Map<Long, Integer> winkelmandMap = winkelmand.getWinkelmandMap();
		Bestelbonlijn bestelbonlijn;
		if (!winkelmandMap.isEmpty() && winkelmandMap.containsKey(bier.getId())) {
			bestelbonlijn = new Bestelbonlijn(winkelmandMap.get(bier.getId()), bier);
		} else {
			bestelbonlijn = new Bestelbonlijn(bier);
		}
		return modelAndView.addObject(bestelbonlijn);
	}


	@PostMapping
	ModelAndView addToWinkelmand(@Validated(Bestelbonlijn.AantalValidatie.class) Bestelbonlijn bestelbonlijn, BindingResult bindingResult, SessionStatus sessionStatus) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(BIER_VIEW).addObject(bestelbonlijn);
		} else {
			winkelmand.setWinkelmandlijn(bestelbonlijn.getBier().getId(), bestelbonlijn.getAantal());
			sessionStatus.setComplete();
			return new ModelAndView(REDIRECT_URL_NA_ADDTOWINKELMAND);
		}
	}

	@InitBinder("bestelbonlijn")
	void initBinderBestelbonlijn(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
}
