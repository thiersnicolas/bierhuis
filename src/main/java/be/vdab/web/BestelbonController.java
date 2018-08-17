package be.vdab.web;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.entities.Bestelbon;
import be.vdab.entities.Bier;
import be.vdab.services.BestelbonService;
import be.vdab.services.BierService;
import be.vdab.valueobjects.Bestelbonlijn;

@Controller
@RequestMapping("/winkelmand")
@SessionAttributes("bestelbon")
public class BestelbonController {
	private static final String WINKELWAGEN_VIEW = "/bestelbonnen/winkelwagen";
	private static final String REDIRECT_URL_BESTELBON_BEVESTIGEN_VIEW = "redirect:/bestelbonnen/bevestigen";
	
	private BestelbonService bestelbonService;
	private BierService bierService;
	private Winkelmand winkelmand;

	public BestelbonController(BestelbonService bestelbonService, Winkelmand winkelmand, BierService bierService) {
		this.bestelbonService = bestelbonService;
		this.winkelmand = winkelmand;
		this.bierService = bierService;
	}
	
	@GetMapping
	ModelAndView bestelbonWeergeven() {
		Set<Bestelbonlijn> bestelbonlijnen = new TreeSet<>();
		Map<Long, Integer> winkelmandMap = winkelmand.getWinkelmandMap();
		for (Bier bier:bierService.findByIdIn(winkelmandMap.keySet())) {
			Bestelbonlijn bestelbonlijn = new Bestelbonlijn(winkelmandMap.get(bier.getId()), bier);
			bestelbonlijnen.add(bestelbonlijn);
		}
		Bestelbon bestelbon= new Bestelbon(bestelbonlijnen);
		return new ModelAndView(WINKELWAGEN_VIEW).addObject(bestelbon);
	}
	
	@PostMapping
	ModelAndView bestelbonVerwerken(@Validated(Bestelbon.GegevensValidatie.class) Bestelbon bestelbon, BindingResult bindingResult, RedirectAttributes redirectAttributes, SessionStatus sessionStatus) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(WINKELWAGEN_VIEW);
		} else {
			System.out.println(bestelbon.getAdres().toString());
			bestelbon.getBestelbonlijnen().stream().forEach(bestelbonlijn->System.out.println(bestelbonlijn.toString()));
			bestelbonService.create(bestelbon);
			redirectAttributes.addAttribute(bestelbon);
			sessionStatus.setComplete();
			return new ModelAndView(REDIRECT_URL_BESTELBON_BEVESTIGEN_VIEW);
		}
	}
	
	@InitBinder("bestelbonlijn")
	void initBinderBestelbonlijn(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
	@InitBinder("bier")
	void initBinderBier(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
	@InitBinder("soort")
	void initBinderSoort(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
	@InitBinder("bestelbon")
	void initBinderBestelbon(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
	@InitBinder("brouwer")
	void initBinderBrouwer(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
}
