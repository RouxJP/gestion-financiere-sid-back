package dev.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Représente un critère de notation (ex: QCM noté sur 5, catégorie SAVOIR)
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "CRITERE_NOTATION")
@Cacheable(value = true)
public class CritereNotation implements Comparable<CritereNotation>{

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** nom : String */
	@Column(name = "NOM")
	private String nom;

	/** noteMax : Integer */
	@Column(name = "NOTE_MAX")
	private Integer noteMax;

	/** typeNote : TypeNote */
	@Column(name = "TYPE_NOTE")
	@Enumerated(EnumType.STRING)
	private TypeNote typeNote;

	/** bareme : String */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BAREME")
	private Bareme bareme;

	/** cours : Cours */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COURS")
	private Cours cours;

	/**
	 * Constructor
	 * 
	 */
	public CritereNotation() {

	}

	/**
	 * Constructor
	 * 
	 * @param cours
	 *            cours
	 * @param nom
	 *            nom du critère (ex: QCM, TP, etc...)
	 * @param noteMax
	 *            note maximum (ex: 5 ou 20)
	 * @param typeNote
	 *            type de note
	 */
	public CritereNotation(Cours cours, String nom, Integer noteMax, TypeNote typeNote) {
		super();
		this.cours = cours;
		this.nom = nom;
		this.noteMax = noteMax;
		this.typeNote = typeNote;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.nom).append(this.typeNote).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CritereNotation)) {
			return false;
		}
		CritereNotation other = (CritereNotation) obj;
		return new EqualsBuilder().append(this.nom, other.getNom()).append(this.typeNote, other.getTypeNote())
				.isEquals();
	}
	

	@Override
	public int compareTo(CritereNotation o) {
		int compare = this.getTypeNote().getOrdre()-o.getTypeNote().getOrdre();
		if (compare==0) {
			compare = this.getNom().compareTo(o.getNom());
		}
		return compare;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the noteMax
	 */
	public Integer getNoteMax() {
		return noteMax;
	}

	/**
	 * Setter
	 * 
	 * @param noteMax
	 *            the noteMax to set
	 */
	public void setNoteMax(Integer noteMax) {
		this.noteMax = noteMax;
	}

	/**
	 * Getter
	 * 
	 * @return the typeNote
	 */
	public TypeNote getTypeNote() {
		return typeNote;
	}

	/**
	 * Setter
	 * 
	 * @param typeNote
	 *            the typeNote to set
	 */
	public void setTypeNote(TypeNote typeNote) {
		this.typeNote = typeNote;
	}

	/**
	 * Getter
	 * 
	 * @return the cours
	 */
	public Cours getCours() {
		return cours;
	}

	/**
	 * Setter
	 * 
	 * @param cours
	 *            the cours to set
	 */
	public void setCours(Cours cours) {
		this.cours = cours;
	}

	/**
	 * Setter
	 * 
	 * @param bareme
	 *            the bareme to set
	 */
	public void setBareme(Bareme bareme) {
		this.bareme = bareme;
	}

	/**
	 * Getter
	 * 
	 * @return the bareme
	 */
	public Bareme getBareme() {
		return bareme;
	}

}
