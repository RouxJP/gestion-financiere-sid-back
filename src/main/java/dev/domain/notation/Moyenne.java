package dev.domain.notation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.domain.TypeNote;

/**
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "MOYENNE")
public class Moyenne {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** type : TypeNote */
	@Column(name = "TYPE_NOTE")
	@Enumerated(EnumType.STRING)
	private TypeNote type;

	/** valeur : double */
	@Column(name = "VALEUR")
	private double valeur;

	/** bilan : Bilan */
	@ManyToOne
	@JoinColumn(name = "ID_BILAN")
	private BilanStagiaire bilan;

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the type
	 */
	public TypeNote getType() {
		return type;
	}

	/**
	 * Setter
	 * 
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeNote type) {
		this.type = type;
	}

	/**
	 * Getter
	 * 
	 * @return the valeur
	 */
	public double getValeur() {
		return valeur;
	}

	/**
	 * Setter
	 * 
	 * @param valeur
	 *            the valeur to set
	 */
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	/**
	 * Getter
	 * 
	 * @return the bilan
	 */
	public BilanStagiaire getBilan() {
		return bilan;
	}

	/**
	 * Setter
	 * 
	 * @param bilan
	 *            the bilan to set
	 */
	public void setBilan(BilanStagiaire bilan) {
		this.bilan = bilan;
	}

}
