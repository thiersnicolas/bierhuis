package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

import be.vdab.entities.Bier;

@Embeddable
public class Bestelbonlijn implements Serializable, Comparable<Bestelbonlijn> {
	public interface AantalValidatie {}
	
	
	private static final long serialVersionUID = 1L;
	@NotNull(groups = AantalValidatie.class)
	@Min(value=1, groups = AantalValidatie.class)
	private Integer aantal;
	@Valid
	@ManyToOne(optional=false)
	@JoinColumn(name="bierid")
	private Bier bier;
	@Transient
	@NumberFormat(pattern="#,##0.##")
	private BigDecimal waarde;
	
	public Bestelbonlijn() {}
	
	public Bestelbonlijn(Integer aantal, Bier bier) {
		this.aantal = aantal;
		this.bier = bier;
	}
	
	public Bestelbonlijn(Bier bier) {
		this.bier = bier;
	}

	public Integer getAantal() {
		return aantal;
	}

	public Bier getBier() {
		return bier;
	}
	
	public BigDecimal getWaarde() {
		return bier.getPrijs().multiply(BigDecimal.valueOf(aantal));
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

	@Override
	public String toString() {
		return "Bestelbonlijn [aantal=" + aantal + ", bier=" + bier + "]";
	}

	@Override
	public int compareTo(Bestelbonlijn o) {
		return this.bier.compareTo(o.getBier());
	}
	
	
	
	
}
