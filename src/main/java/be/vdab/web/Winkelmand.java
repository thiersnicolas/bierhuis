package be.vdab.web;

import java.util.Map;

public interface Winkelmand {
	void setWinkelmandlijn(long productId, int aantal);
	Map<Long, Integer> getWinkelmandMap();
	void setWinkelmandMap(Map<Long, Integer> winkelmand);
	
}
