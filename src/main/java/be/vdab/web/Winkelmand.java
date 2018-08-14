package be.vdab.web;

import java.util.List;

public interface Winkelmand {
	void addBestellijn(WinkelmandLijn lijn);
	List<WinkelmandLijn> findWinkelmandLijnen();
}
