package be.vdab.web;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BierWinkelmandLijn implements WinkelmandLijn, Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	private long productId;
	@NotNull
	@Min(1)
	private int aantal;

	@Override
	public void setProductId(long id) {
		productId = id;
	}

	@Override
	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	@Override
	public long getProductId() {
		return productId;
	}

	@Override
	public int getAantal() {
		return aantal;
	}

}
