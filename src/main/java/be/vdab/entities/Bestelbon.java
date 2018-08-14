package be.vdab.entities;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

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

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.Bestelbonlijn;

@Entity
@Table(name="bestelbonlijnen")
public class Bestelbon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@SafeHtml
	@Length(min=1, max=50)
	private String naam;
	@Valid
	@Embedded
	private Adres adres;
	@Valid
	@ElementCollection
	@CollectionTable(name="bestelbonlijnen", joinColumns= @JoinColumn(name="bestelbonid"))
	private Set<Bestelbonlijn> bestelbonlijnen;
	
	protected Bestelbon() {}
	
	public Bestelbon(String naam, Adres adres) {
		bestelbonlijnen=new LinkedHashSet<>();
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
		return bestelbonlijnen;
	}
}
