package dev.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Représente un barême de notations
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "BAREME")
@Cacheable(value = true)
public class Bareme {

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

	/** typeBareme : TypeCours */
	@Column(name = "TYPE_BAREME")
	@Enumerated(EnumType.STRING)
	private TypeNote typeBareme;

	/** informations : String */
	@Column(name = "INFORMATIONS")
	private String informations;

	/** details : List de DetailBareme */
	@OneToMany(mappedBy = "bareme", fetch = FetchType.LAZY)
	List<DetailBareme> details = new ArrayList<>();

	/**
	 * Recherche un détail du barême en fonction de son id
	 * 
	 * @param id id du détail
	 * @return {@link DetailBareme}
	 */
	public Optional<DetailBareme> getDetail(Long id) {
		return details.stream().filter(d -> d.getId() != null && d.getId().equals(id)).findFirst();
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
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the details
	 */
	public List<DetailBareme> getDetails() {
		return details;
	}

	/**
	 * Setter
	 * 
	 * @param details the details to set
	 */
	public void setDetails(List<DetailBareme> details) {
		this.details = details;
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
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the informations
	 */
	public String getInformations() {
		return informations;
	}

	/**
	 * Setter
	 * 
	 * @param informations the informations to set
	 */
	public void setInformations(String informations) {
		this.informations = informations;
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
	 * @param noteMax the noteMax to set
	 */
	public void setNoteMax(Integer noteMax) {
		this.noteMax = noteMax;
	}

	/**
	 * Getter
	 * 
	 * @return the typeBareme
	 */
	public TypeNote getTypeBareme() {
		return typeBareme;
	}

	/**
	 * Setter
	 * 
	 * @param typeBareme the typeBareme to set
	 */
	public void setTypeBareme(TypeNote typeBareme) {
		this.typeBareme = typeBareme;
	}

}
