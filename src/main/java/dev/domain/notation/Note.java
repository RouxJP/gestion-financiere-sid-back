package dev.domain.notation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.domain.CritereNotation;

/**
 * Représente une note, un résultat à un atelier, un QCM ou une note de
 * savoir-être
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "NOTE")
public class Note implements Comparable<Note>{

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** valeur : double */
	@Column(name = "VALEUR")
	private String valeur;

	/** critereNotation : CritereNotation */
	@ManyToOne
	@JoinColumn(name = "ID_CRITERE")
	private CritereNotation critereNotation;

	/** resultat : ResultatCours */
	@Column(name = "ID_RESULTAT")
	private Long idResultat;

	/**
	 * Constructor
	 * 
	 */
	public Note() {

	}

	/**
	 * Constructor
	 * 
	 * @param critereNotation
	 *            critère de notation
	 * @param valeur
	 *            valeur de la note
	 */
	public Note(CritereNotation critereNotation, String valeur) {
		super();
		this.critereNotation = critereNotation;
		this.valeur = valeur;
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 *            identifiant
	 * @param valeur
	 *            valeur de la note
	 */
	public Note(Long id, String valeur) {
		super();
		this.id = id;
		this.valeur = valeur;
	}
	

	@Override
	public int compareTo(Note o) {
		return this.critereNotation.compareTo(o.getCritereNotation());
	}

	@Override
	public String toString() {
		return critereNotation.getCours().getLibelle() + " - Type: " + critereNotation.getTypeNote().getLibelle()
				+ " - Coefficient: " + critereNotation.getCours().getCoefficient() + " - note:" + getValeur();
	}

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
	 * @return the valeur
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * Setter
	 * 
	 * @param valeur
	 *            the valeur to set
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	/**
	 * Getter
	 * 
	 * @return the critereNotation
	 */
	public CritereNotation getCritereNotation() {
		return critereNotation;
	}

	/**
	 * Setter
	 * 
	 * @param critereNotation
	 *            the critereNotation to set
	 */
	public void setCritereNotation(CritereNotation critereNotation) {
		this.critereNotation = critereNotation;
	}

	/**
	 * Getter
	 * 
	 * @return the idResultat
	 */
	public Long getIdResultat() {
		return idResultat;
	}

	/**
	 * Setter
	 * 
	 * @param idResultat
	 *            the idResultat to set
	 */
	public void setIdResultat(Long idResultat) {
		this.idResultat = idResultat;
	}

}
