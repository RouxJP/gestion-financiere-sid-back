package dev.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente le détail d'un barême
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "DETAIL_BAREME")
@Cacheable(value = true)
public class DetailBareme {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** note : Integer */
	@Column(name = "NOTE")
	private Integer note;

	/** libelle : String */
	@Column(name = "LIBELLE")
	private String libelle;

	/** bareme : Bareme */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BAREME")
	private Bareme bareme;

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
	 * @return the note
	 */
	public Integer getNote() {
		return note;
	}

	/**
	 * Setter
	 * 
	 * @param note
	 *            the note to set
	 */
	public void setNote(Integer note) {
		this.note = note;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter
	 * 
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the bareme
	 */
	public Bareme getBareme() {
		return bareme;
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
}
