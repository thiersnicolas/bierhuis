package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="bieren")
@NamedEntityGraph(name="Bier.metBrouwerEnSoort", attributeNodes= {
		@NamedAttributeNode("brouwer"), @NamedAttributeNode("soort")})
public class Bier implements Serializable, Comparable<Bier> {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Length(min=1, max=100)
	private String naam;
	@Valid
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="brouwerid")
	private Brouwer brouwer;
	@Valid
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="soortid")
	private Soort soort;
	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Digits(integer=7, fraction=2)
	@Min(0)
	private BigDecimal Alcohol;
	@NotNull
	@Digits(integer=19, fraction=2)
	@Min(0)
	@NumberFormat(pattern="#,##0.##")
	private BigDecimal prijs;
	
	protected Bier() {}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public Brouwer getBrouwer() {
		return brouwer;
	}

	public Soort getSoort() {
		return soort;
	}

	public BigDecimal getAlcohol() {
		return Alcohol;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brouwer == null) ? 0 : brouwer.hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
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
		Bier other = (Bier) obj;
		if (brouwer == null) {
			if (other.brouwer != null)
				return false;
		} else if (!brouwer.equals(other.brouwer))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bier [id=" + id + ", naam=" + naam + ", brouwer=" + brouwer + ", soort=" + soort + ", Alcohol="
				+ Alcohol + ", prijs=" + prijs + "]";
	}


	@Override
	public int compareTo(Bier o) {
		return this.getNaam().compareTo(o.getNaam());
	}
	
	
}
