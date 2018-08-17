package be.vdab.web;

import java.util.Map;

public interface Winkelmand {
	boolean addWinkelmandlijn(long productId, int aantal);
	Map<Long, Integer> getWinkelmandMap();
	void setWinkelmandMap(Map<Long, Integer> winkelmand);
	
}
