package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import be.vdab.entities.Bier;

@Embeddable
public class Bestelbonlijn implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	@Min(1)
	private Integer aantal;
	@Valid
	@ManyToOne(optional=false)
	@JoinColumn(name="bierid")
	private Bier bier;
	
	protected Bestelbonlijn() {}
	
	public Bestelbonlijn(Integer aantal, Bier bier) {
		this.aantal = aantal;
		this.bier = bier;
	}

	public Integer getAantal() {
		return aantal;
	}

	public Bier getBier() {
		return bier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bier == null) ? 0 : bier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bestelbonlijn other = (Bestelbonlijn) obj;
		if (bier == null) {
			if (other.bier != null)
				return false;
		} else if (!bier.equals(other.bier))
			return false;
		return true;
	}
	
	
	
	
}
