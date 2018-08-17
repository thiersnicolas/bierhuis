package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.Bestelbonlijn;

@Entity
@Table(name = "bestelbonlijnen")
public class Bestelbon implements Serializable {
	public interface GegevensValidatie {}
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(groups = GegevensValidatie.class)
	@SafeHtml(groups = GegevensValidatie.class)
	@Length(min = 1, max = 50, groups = GegevensValidatie.class)
	private String naam;
	@Valid
	@Embedded
	private Adres adres;
	@Valid
	@ElementCollection
	@CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name = "bestelbonid"))
	private Set<Bestelbonlijn> bestelbonlijnen;
	@NumberFormat(pattern="#,##0.##")
	private BigDecimal waarde;

	public Bestelbon() {
	}

	public Bestelbon(Set<Bestelbonlijn> bestelbonlijnen) {
		this.bestelbonlijnen = bestelbonlijnen;
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public Set<Bestelbonlijn> getBestelbonlijnen() {
		return Collections.unmodifiableSet(new TreeSet<Bestelbonlijn>(bestelbonlijnen));
	}

	public boolean addBestelbonlijn(@Valid Bestelbonlijn bestelbonlijn) {
		return bestelbonlijnen.add(bestelbonlijn);
	}

	public Optional<Bestelbonlijn> getBestelbonlijn(@Valid Bier bier) {
		for (Bestelbonlijn bestelbonlijn : bestelbonlijnen) {
			if (bestelbonlijn.getBier().equals(bier)) {
				return Optional.ofNullable(bestelbonlijn);
			}
		}
		return Optional.empty();
	}

	public BigDecimal getWaarde() {
		BigDecimal waarde = new BigDecimal(0);
		for (Bestelbonlijn bestelbonlijn : bestelbonlijnen) {
			waarde = waarde.add(bestelbonlijn.getWaarde());
		}
		return waarde;
	}

	@Override
	public String toString() {
		return "Bestelbon [id=" + id + ", naam=" + naam + ", adres=" + adres + ", bestelbonlijnen=" + bestelbonlijnen
				+ "]";
	}
}
