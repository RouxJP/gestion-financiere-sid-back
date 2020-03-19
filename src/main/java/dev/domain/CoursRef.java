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
 * Représente un cours de référence
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "COURS_REF")
@Cacheable(value = true)
public class CoursRef {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/** libelle : String */
	@Column(name = "LIBELLE")
	private String libelle;

	/** libelleCourt : String */
	@Column(name = "LIBELLE_COURT")
	private String libelleCourt;

	/** typeCours : TypeCours */
	@Column(name = "TYPE_COURS")
	@Enumerated(EnumType.STRING)
	private TypeCours typeCours;

	/** dureeDefaut : String */
	@Column(name = "DUREE_DEFAUT", length = 3)
	private Integer dureeDefaut;

	/** coeffDefaut : String */
	@Column(name = "COEFF_DEFAUT", length = 3)
	private Integer coeffDefaut;

	/** rubrique : Rubrique */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RUBRIQUE")
	private Rubrique rubrique;

	/** prerequis : String */
	@Column(name = "PREREQUIS")
	private String prerequis;

	/** description : String */
	@Column(name = "DESCRIPTION")
	private String description;

	/** objectifsPedagogiques : objectifs pédagogiques */
	@Column(name = "OBJS_PEDAGOGIQUES")
	private String objectifsPedagogiques;

	/**
	 * Constructor
	 * 
	 */
	public CoursRef() {

	}

	/**
	 * Constructor
	 * 
	 * @param libelle libellé
	 */
	public CoursRef(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof CoursRef)) {
			return false;
		}
		CoursRef other = (CoursRef) object;
		return new EqualsBuilder().append(this.libelle, other.getLibelle()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.libelle).toHashCode();
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
	 * @param id the id to set
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
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the libelleCourt
	 */
	public String getLibelleCourt() {
		return libelleCourt;
	}

	/**
	 * Setter
	 * 
	 * @param libelleCourt the libelleCourt to set
	 */
	public void setLibelleCourt(String libelleCourt) {
		this.libelleCourt = libelleCourt;
	}

	/**
	 * Getter
	 * 
	 * @return the dureeDefaut
	 */
	public Integer getDureeDefaut() {
		return dureeDefaut;
	}

	/**
	 * Setter
	 * 
	 * @param dureeDefaut the dureeDefaut to set
	 */
	public void setDureeDefaut(Integer dureeDefaut) {
		this.dureeDefaut = dureeDefaut;
	}

	/**
	 * Getter
	 * 
	 * @return the coeffDefaut
	 */
	public Integer getCoeffDefaut() {
		return coeffDefaut;
	}

	/**
	 * Setter
	 * 
	 * @param coeffDefaut the coeffDefaut to set
	 */
	public void setCoeffDefaut(Integer coeffDefaut) {
		this.coeffDefaut = coeffDefaut;
	}

	/**
	 * Getter
	 * 
	 * @return the typeCours
	 */
	public TypeCours getTypeCours() {
		return typeCours;
	}

	/**
	 * Setter
	 * 
	 * @param typeCours the typeCours to set
	 */
	public void setTypeCours(TypeCours typeCours) {
		this.typeCours = typeCours;
	}

	/**
	 * Getter
	 * 
	 * @return the rubrique
	 */
	public Rubrique getRubrique() {
		return rubrique;
	}

	/**
	 * Setter
	 * 
	 * @param rubrique the rubrique to set
	 */
	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}

	/**
	 * Getter
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter
	 * 
	 * @return the prerequis
	 */
	public String getPrerequis() {
		return prerequis;
	}

	/**
	 * Setter
	 * 
	 * @param prerequis the prerequis to set
	 */
	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	/**
	 * Getter
	 * 
	 * @return the objectifsPedagogiques
	 */
	public String getObjectifsPedagogiques() {
		return objectifsPedagogiques;
	}

	/**
	 * Setter
	 * 
	 * @param objectifsPedagogiques the objectifsPedagogiques to set
	 */
	public void setObjectifsPedagogiques(String objectifsPedagogiques) {
		this.objectifsPedagogiques = objectifsPedagogiques;
	}
}
