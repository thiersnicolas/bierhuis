package be.vdab.web;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class DefaultWinkelmand implements Winkelmand, Serializable {
	private static final long serialVersionUID = 1L;
	private Map<Long, Integer> winkelmandMap;

	protected DefaultWinkelmand() {
		winkelmandMap = new TreeMap<>();
	}

	@Override
	public void setWinkelmandlijn(long productId, int aantal) {
		if (winkelmandMap.containsKey(productId)) {
			winkelmandMap.replace(productId, aantal);
		} else {
			winkelmandMap.put(productId, aantal);
		}
	}

	@Override
	public Map<Long, Integer> getWinkelmandMap() {
		return winkelmandMap;
	}

	@Override
	public void setWinkelmandMap(Map<Long, Integer> winkelmandMap) {
		this.winkelmandMap = winkelmandMap;
	}

	@Override
	public void clearWinkelmand() {
		winkelmandMap.clear();
	}
}
