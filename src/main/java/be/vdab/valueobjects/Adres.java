package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;

@Embeddable
public class Adres implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank
	@SafeHtml
	@Length(min=1, max=50)
	private String straat;
	@NotBlank
	@SafeHtml
	@Length(min=1, max=50)
	private String huisNr;
	@NotNull
	@Range(min=1000, max=9999)
	@Length(min=1, max=50)
	private String postcode;
	@NotBlank
	@SafeHtml
	@Length(min=1, max=50)
	private String gemeente;
	
	protected Adres () {}
	
	public Adres(String straat, String huisNr, String postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gemeente == null) ? 0 : gemeente.hashCode());
		result = prime * result + ((huisNr == null) ? 0 : huisNr.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((straat == null) ? 0 : straat.hashCode());
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
		Adres other = (Adres) obj;
		if (gemeente == null) {
			if (other.gemeente != null)
				return false;
		} else if (!gemeente.equals(other.gemeente))
			return false;
		if (huisNr == null) {
			if (other.huisNr != null)
				return false;
		} else if (!huisNr.equals(other.huisNr))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (straat == null) {
			if (other.straat != null)
				return false;
		} else if (!straat.equals(other.straat))
			return false;
		return true;
	}
	
	
}
