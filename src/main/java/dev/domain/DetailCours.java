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
 * Détail du contenu d'un chapitre (permet de décrire le contenu d'un chapitre,
 * style Syllabus)
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "DETAIL_COURS")
@Cacheable(value = true)
public class DetailCours {

	/** identifiant */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** libelle : String */
	@Column(name = "LIBELLE")
	private String libelle;

	/** chapitre : Chapitre */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CHAPITRE")
	private Chapitre chapitre;

	/**
	 * Constructor
	 * 
	 */
	public DetailCours() {
	}

	/**
	 * Getter for id
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
	 * Getter for libelle
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

}
