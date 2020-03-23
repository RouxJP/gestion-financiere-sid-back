package dev.domain;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Chapitre d'un cours (permet de décrire le contenu d'un cours, style Syllabus)
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "CHAPITRE")
@Cacheable(value = true)
public class Chapitre {

	/** identifiant */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** libellé du chapitre */
	@Column(name = "LIBELLE")
	private String libelle;

	/** details du chapitre */
	@OneToMany(mappedBy = "chapitre", fetch = FetchType.LAZY)
	private List<DetailCours> details;

	/** cours associé */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COURS")
	private Cours cours;

	/**
	 * Constructor
	 * 
	 */
	public Chapitre() {
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

	/**
	 * Getter for cours
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

}
