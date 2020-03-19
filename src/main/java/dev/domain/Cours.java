package dev.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dgn.administration.modalitespedagogiques.ModalitePedagogiqueDto;

/**
 * Représente un cours donné lors d'une formation avec un libellé et une durée
 * 
 * @author DIGINAMIC
 */
@Entity
@Table(name = "COURS")
@Cacheable
public class Cours implements Comparable<Cours> {

	/** identifiant */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/** libelle du cours */
	@Column(name = "LIBELLE")
	private String libelle;

	/** libelleRacine : String */
	@Column(name = "LIBELLE_RACINE")
	private String libelleRacine;

	/** libelle court du cours */
	@Column(name = "LIBELLE_COURT")
	private String libelleCourt;

	/** libelle court racine du cours */
	@Column(name = "LIBELLE_COURT_RACINE")
	private String libelleCourtRacine;

	/** duree en nb de jours */
	@Column(name = "DUREE")
	private int duree;

	/** duree en nb de jours */
	@Column(name = "COEFF")
	private int coefficient;

	/** typeCours : TypeCours */
	@Column(name = "TYPE_COURS")
	@Enumerated(EnumType.STRING)
	private TypeCours typeCours;

	/** coursRef : CoursRef */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COURS_REF")
	private CoursRef coursRef;

	/**
	 * module auquel le cours appartient (Module 'Default' si la formation est sans module)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MODULE")
	private Module module;

	/** formation à laquelle le cours appartient */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FORMATION")
	private Formation formation;

	/**
	 * Liste des chapitres (dans le cadre d'une description du contenu du cours)
	 */
	@OneToMany(mappedBy = "cours", fetch = FetchType.LAZY)
	private List<Chapitre> chapitres = new ArrayList<>();

	/**
	 * Liste des formateurs qui ont les compétences pour donner cette formation
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "COURS_PAR_FORMATEUR", joinColumns = @JoinColumn(name = "ID_COU", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_FORMATEUR", referencedColumnName = "ID"))
	private List<Utilisateur> formateurs = new ArrayList<>();

	/** Date de dernière mise à jour */
	@Column(name = "DATE_MAJ")
	private LocalDateTime dateMaj;

	/** Auteur de la dernière mise à jour */
	@Column(name = "USER_MAJ")
	private String userMaj;

	/** criteres : List de CritereNotation */
	@OneToMany(mappedBy = "cours", fetch = FetchType.LAZY)
	private Set<CritereNotation> criteres = new HashSet<>();

	/** ordre : Integer */
	@Column(name = "ORDRE")
	private Integer ordre;

	/** supprimer : indique si le cours est à supprimer ou non */
	@Transient
	private boolean supprimer;

	/** modifiable : boolean */
	@Transient
	private boolean modifiable;

	/** rubrique : Rubrique */
	@Transient
	private Rubrique rubrique;

	/** modalité pédagogique à laquelle le cours appartient */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MODALITE_PEDAGOGIQUE")
	private ModalitePedagogique modalitePedagogique;
	/**
	 * Constructeur
	 */
	public Cours() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param libelle libellé
	 * @param coefficient coefficient
	 */
	public Cours(String libelle, int coefficient) {
		super();
		this.libelle = libelle;
		this.coefficient = coefficient;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.libelle).append(this.supprimer).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cours)) {
			return false;
		}
		Cours other = (Cours) obj;
		return new EqualsBuilder().append(this.libelle, other.getLibelle()).append(this.supprimer, other.isSupprimer())
				.isEquals();
	}

	@Override
	public int compareTo(Cours other) {
		return ordre.compareTo(other.getOrdre());
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
	 * Getter for duree
	 * 
	 * @return the duree
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * Setter
	 * 
	 * @param duree the duree to set
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * Getter for formateurs
	 * 
	 * @return the formateurs
	 */
	public List<Utilisateur> getFormateurs() {
		return formateurs;
	}

	/**
	 * Setter
	 * 
	 * @param formateurs the formateurs to set
	 */
	public void setFormateurs(List<Utilisateur> formateurs) {
		this.formateurs = formateurs;
	}

	/**
	 * Getter for chapitres
	 * 
	 * @return the chapitres
	 */
	public List<Chapitre> getChapitres() {
		return chapitres;
	}

	/**
	 * Setter
	 * 
	 * @param chapitres the chapitres to set
	 */
	public void setChapitres(List<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}

	/**
	 * Getter for module
	 * 
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * Setter
	 * 
	 * @param module the module to set
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * Getter
	 * 
	 * @return the formation
	 */
	public Formation getFormation() {
		return formation;
	}

	/**
	 * Setter
	 * 
	 * @param formation the formation to set
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	/**
	 * Getter
	 * 
	 * @return the dateMaj
	 */
	public LocalDateTime getDateMaj() {
		return dateMaj;
	}

	/**
	 * Setter
	 * 
	 * @param dateMaj the dateMaj to set
	 */
	public void setDateMaj(LocalDateTime dateMaj) {
		this.dateMaj = dateMaj;
	}

	/**
	 * Getter
	 * 
	 * @return the userMaj
	 */
	public String getUserMaj() {
		return userMaj;
	}

	/**
	 * Setter
	 * 
	 * @param userMaj the userMaj to set
	 */
	public void setUserMaj(String userMaj) {
		this.userMaj = userMaj;
	}

	/**
	 * Getter
	 * 
	 * @return the coefficient
	 */
	public int getCoefficient() {
		return coefficient;
	}

	/**
	 * Setter
	 * 
	 * @param coefficient the coefficient to set
	 */
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
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
	 * @return the criteres
	 */
	public Set<CritereNotation> getCriteres() {
		return criteres;
	}

	/**
	 * Setter
	 * 
	 * @param criteres the criteres to set
	 */
	public void setCriteres(Set<CritereNotation> criteres) {
		this.criteres = criteres;
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
	 * @return the coursRef
	 */
	public CoursRef getCoursRef() {
		return coursRef;
	}

	/**
	 * Setter
	 * 
	 * @param coursRef the coursRef to set
	 */
	public void setCoursRef(CoursRef coursRef) {
		this.coursRef = coursRef;
	}

	/**
	 * Getter
	 * 
	 * @return the ordre
	 */
	public Integer getOrdre() {
		return ordre;
	}

	/**
	 * Setter
	 * 
	 * @param ordre the ordre to set
	 */
	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	/**
	 * Getter
	 * 
	 * @return the supprimer
	 */
	public boolean isSupprimer() {
		return supprimer;
	}

	/**
	 * Setter
	 * 
	 * @param supprimer the supprimer to set
	 */
	public void setSupprimer(boolean supprimer) {
		this.supprimer = supprimer;
	}

	/**
	 * Getter
	 * 
	 * @return the libelleRacine
	 */
	public String getLibelleRacine() {
		return libelleRacine;
	}

	/**
	 * Setter
	 * 
	 * @param libelleRacine the libelleRacine to set
	 */
	public void setLibelleRacine(String libelleRacine) {
		this.libelleRacine = libelleRacine;
	}

	/**
	 * Getter
	 * 
	 * @return the libelleCourtRacine
	 */
	public String getLibelleCourtRacine() {
		return libelleCourtRacine;
	}

	/**
	 * Setter
	 * 
	 * @param libelleCourtRacine the libelleCourtRacine to set
	 */
	public void setLibelleCourtRacine(String libelleCourtRacine) {
		this.libelleCourtRacine = libelleCourtRacine;
	}

	/**
	 * Getter
	 * 
	 * @return the modifiable
	 */
	public boolean isModifiable() {
		return modifiable;
	}

	/**
	 * Setter
	 * 
	 * @param modifiable the modifiable to set
	 */
	public void setModifiable(boolean modifiable) {
		this.modifiable = modifiable;
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

	/** Getter
	 * 
	 * @return the modalitePedagogique
	 */
	public ModalitePedagogique getModalitePedagogique() {
		return modalitePedagogique;
	}

	/** Setter
	 * 
	 * @param modalitePedagogique the modalitePedagogique to set
	 */
	public void setModalitePedagogique(ModalitePedagogique modalitePedagogique) {
		this.modalitePedagogique = modalitePedagogique;
	}

	
	
}
