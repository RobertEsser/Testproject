package de.telekom.sea7;

/** Diese Klasse dient als Beschreibung für IBAN und 
 * beinhaltet die Entität der DB-Tabelle mit Namen IBAN.
 * 
 */

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "iban")
public class EntityIBAN {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String iban;
	/**
	 * Durch die Annotation @JoinColumn wir die Spalte "bic_id" als die Spalte
	 * festgelegt welche zur EntityBIC die Verindung (Join) herstellt.@ManyToOne
	 * (Mapping) besagt das es mehrere IBAN zu einer BIC geben könnte
	 */

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "bic_id")

//	private EntityBIC entityBIC;

	public EntityIBAN(long id, String iban) {
		this.id=id;
		this.iban=iban;
	}

	public EntityIBAN() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

//	public EntityBIC getEntityBIC() {
//		return entityBIC;
//	}

//	public void setEntityBIC(EntityBIC entityBIC) {
//		this.entityBIC = entityBIC;
//	}

}