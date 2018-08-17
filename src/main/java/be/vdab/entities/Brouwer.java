package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name="brouwers")
@NamedEntityGraph(name="Brouwer.metAdres" , attributeNodes=@NamedAttributeNode("adres"))
public class Brouwer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Length(min=1, max=50)
	private String naam;
	@Valid
	@Embedded
	private Adres adres;
	@Min(0)
	private Integer omzet;
	@OneToMany
	@JoinColumn(name="brouwerid")
	private Set<Bier> bieren;
	
	public Set<Bier> getBieren() {
		return Collections.unmodifiableSet(new TreeSet<Bier>(bieren));
	}

	protected Brouwer() {}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public Integer getOmzet() {
		return omzet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adres == null) ? 0 : adres.hashCode());
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
		Brouwer other = (Brouwer) obj;
		if (adres == null) {
			if (other.adres != null)
				return false;
		} else if (!adres.equals(other.adres))
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
		return "Brouwer [id=" + id + ", naam=" + naam + ", adres=" + adres + ", omzet=" + omzet + "]";
	}
	
	
}
