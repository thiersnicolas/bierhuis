package be.vdab.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class DefaultWinkelmand implements Serializable, Winkelmand {
	private static final long serialVersionUID = 1L;
	private List<WinkelmandLijn> winkelmandLijnen = new ArrayList<>();

	@Override
	public void addBestellijn(WinkelmandLijn lijn) {
		winkelmandLijnen.add(lijn);
	}

	@Override
	public List<WinkelmandLijn> findWinkelmandLijnen() {
		return winkelmandLijnen;
	}

}
