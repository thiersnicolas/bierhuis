package be.vdab.web;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class DefaultWinkelmand implements Winkelmand, Serializable {
	private static final long serialVersionUID = 1L;
	private Map<Long, @NotNull@Min(1)@Digits(fraction=0, integer=10)Integer> winkelmandMap;
	
	protected DefaultWinkelmand() {
		winkelmandMap = new TreeMap<>();
	}

	@Override
	public boolean addWinkelmandlijn(long productId, int aantal) {
		if (winkelmandMap.containsKey(productId)) {
			return false;
		} else {
			winkelmandMap.put(productId, aantal);
			return true;
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

}
