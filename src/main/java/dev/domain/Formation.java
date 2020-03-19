package dev.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Représente une formation avec son nom, ses modules (au moins 1 par défaut) et ses cours.
 * 
 * @author DIGINAMIC
 */
@Entity
@Table(name = "FORMATION")
@Cacheable
public class Formation {

	/** identifiant */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/** nom de la formation */
	@Column(name = "NOM")
	private String nom;

	/** nom de la formation */
	@Column(name = "NOM_COURT")
	private String nomCourt;

	/** reference : String */
	@Column(name = "REFERENCE", length = 10)
	private String reference;
	/**
	 * Indique par OUI ou par NON si la formation donne lieu à la délivrance d'un titre pro.
	 */
	@Column(name = "TITRE")
	private String titre;

	/**
	 * Date de fin de la formation dans le cas où un admin supprime une formation pour laquelle des sessions ont déjà eu lieu
	 */
	@Column(name = "DATE_FIN")
	private LocalDate dateFin;

	/** Indique si la formation est avec module ou non */
	@Column(name = "AVEC_MODULE")
	private boolean avecModule;

	/**
	 * Liste des modules (une formation sans module a malgré tout un unique module, masqué à l'affichage, qui s'appelle Default)
	 */
	@OneToMany(mappedBy = "formation", fetch = FetchType.LAZY)
	private Set<Module> modules = new HashSet<>();

	/** Date de dernière mise à jour */
	@Column(name = "DATE_MAJ")
	private LocalDateTime dateMaj;

	/** Auteur de la dernière mise à jour */
	@Column(name = "USER_MAJ")
	private String userMaj;

	/** version : Integer */
	@Column(name = "VERSION")
	private Integer version;

	/** duree : Integer */
	@Column(name = "DUREE")
	private Integer duree;

	/**
	 * Représente la version précédente d'une formation (si la formation est la première alors previous vaut NULL)
	 */
	@Column(name = "ID_PREVIOUS")
	private Long idPrevious;

	/**
	 * Représente la version d'origine de la formation (celle pour laquelle id == idParent)
	 */
	@Column(name = "ID_PARENT")
	private Long idParent;

	/**
	 * Représente la version suivante d'une formation (si la formation est la dernière alors next vaut NULL)
	 */
	@Column(name = "ID_NEXT")
	private Long idNext;

	/** objectifsPedagogiques : objectifs pédagogiques */
	@Column(name = "OBJS_PEDAGOGIQUES")
	private String objectifsPedagogiques;

	/** Texte pré-requis apparaissant dans le syllabus */
	@Column(name = "PRE_REQUIS")
	private String preRequis;

	/** Texte de présentation formation apparaissant dans le syllabus */
	@Column(name = "INTRO_SYLLABUS")
	private String introSyllabus;

	/** projetFin : projet de fin de formation */
	@Column(name = "PROJET_FIN")
	private String projetFin;

	/**
	 * evalAmont : Phrase concernant l'évaluation amont et qui apparait dans le bilan de fin de formation du stagiaire en entête de document
	 */
	@Column(name = "EVAL_AMONT")
	private String evalAmont;

	/** nom de la certification (facultatif) */
	@Column(name = "REFERENCE_EXAMEN")
	private String referenceExamen;

	/** editeurCertification : String */
	@Column(name = "EDITEUR_CERTIFICATION")
	private String editeurCertification;

	/** nom de la certification (facultatif) */
	@Column(name = "NOM_CERTIF")
	private String nomCertification;

	/** nom de la certification (facultatif) */
	@Column(name = "NB_CERTIFS_BLANCHES")
	private Integer nbCertifsBlanches;

	/**
	 * scoreObtentionCertif : Score permettant l'obtention de la certification
	 */
	@Column(name = "SCORE_OBTENTION_CERTIF")
	private Integer scoreObtentionCertif;

	/**
	 * infosCertif : Documentation concernant la certification
	 */
	@Column(name = "INFOS_CERTIF")
	private String infosCertif;

	/** nom du logo de la certification (facultatif) */
	@Column(name = "NOM_LOGO_CERTIF")
	private String nomLogoCertification;

	/**
	 * Constructeur
	 */
	public Formation() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param nom nom de la formation
	 */
	public Formation(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * Constructor
	 * 
	 * @param id identifiant
	 */
	public Formation(Long id) {
		this.id = id;
	}

	/**
	 * Constructeur avec les infos utiles de la formation
	 * 
	 * @param id identifiant
	 * @param nom nom de la formation
	 * @param reference référence
	 * @param version numéro de version
	 * @param idParent identifiant du parent
	 * @param duree durée
	 */
	public Formation(Long id, String nom, String reference, Integer version, Long idParent, Integer duree) {
		super();
		this.id = id;
		this.nom = nom;
		this.reference = reference;
		this.version = version;
		this.idParent = idParent;
		this.duree = duree;
	}

	/**
	 * Constructeur avec les infos utiles de la formation
	 * 
	 * @param id identifiant
	 * @param nomCertification nom de la certification
	 */
	public Formation(Long id, String nomCertification) {
		super();
		this.id = id;
		this.nomCertification = nomCertification;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Formation)) {
			return false;
		}
		Formation other = (Formation) object;
		return new EqualsBuilder().append(this.nom, other.getNom()).append(this.reference, other.getReference())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.nom).append(this.reference).toHashCode();
	}

	/**
	 * Calcule la durée de la formation
	 * 
	 * @return int
	 */
	public int calculerDuree() {
		return modules.stream().mapToInt(Module::getDuree).sum();
	}

	/**
	 * Retourne la durée de la formation
	 * 
	 * @return int
	 */
	public Integer getDuree() {
		return duree;
	}

	/**
	 * Retourne true si la formation contient le cours passé en paramètre
	 * 
	 * @param cours cours à rechercher dans la formation
	 * @return boolean
	 */
	public boolean contientCoursByLibelle(Cours cours) {
		return modules.stream().filter(m -> m.getCours().contains(cours)).count() > 0;
	}

	/**
	 * Retourne la liste des cours dont le libellé racine est passé en paramètre
	 * 
	 * @param libelleRacine libellé racine des cours à rechercher
	 * @return List de {@link Cours}
	 */
	public List<Cours> getCoursByLibelleRacine(String libelleRacine) {
		return modules.stream().flatMap(m -> m.getCours().stream())
				.filter(c -> c.getLibelleRacine().equals(libelleRacine)).collect(Collectors.toList());
	}

	/**
	 * Récupère la liste de tous les cours d'une formation
	 * 
	 * @return List de Cours
	 */
	public List<Cours> getCours() {
		return modules.stream().flatMap(m -> m.getCours().stream()).collect(Collectors.toList());
	}

	/**
	 * Retourne true si la formation contient le cours passé en paramètre
	 * 
	 * @param cours cours à rechercher dans la formation
	 * @return boolean
	 */
	public boolean contientCoursById(Cours cours) {
		if (cours.getId() == null) {
			return false;
		}
		for (Module module : modules) {
			for (Cours oldCours : module.getCours()) {
				if (oldCours.getId() != null && oldCours.getId().equals(cours.getId())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Getter for nom
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
	 * Getter for nomCertification
	 * 
	 * @return the nomCertification
	 */
	public String getNomCertification() {
		return nomCertification;
	}

	/**
	 * Setter
	 * 
	 * @param nomCertification the nomCertification to set
	 */
	public void setNomCertification(String nomCertification) {
		this.nomCertification = nomCertification;
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
	 * Getter for titre
	 * 
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * Setter
	 * 
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * Getter for dateFin
	 * 
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * Setter
	 * 
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Getter for dateMaj
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
	 * Getter for userMaj
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
	 * Getter for modules
	 * 
	 * @return the modules
	 */
	public Set<Module> getModules() {
		return modules;
	}

	/**
	 * Setter
	 * 
	 * @param modules the modules to set
	 */
	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	/**
	 * Getter for avecModule
	 * 
	 * @return the avecModule
	 */
	public boolean isAvecModule() {
		return avecModule;
	}

	/**
	 * Setter
	 * 
	 * @param avecModule the avecModule to set
	 */
	public void setAvecModule(boolean avecModule) {
		this.avecModule = avecModule;
	}

	/**
	 * Getter
	 * 
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * Setter
	 * 
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * Getter
	 * 
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Setter
	 * 
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
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

	/**
	 * Getter
	 * 
	 * @return the projetFin
	 */
	public String getProjetFin() {
		return projetFin;
	}

	/**
	 * Setter
	 * 
	 * @param projetFin the projetFin to set
	 */
	public void setProjetFin(String projetFin) {
		this.projetFin = projetFin;
	}

	/**
	 * Getter
	 * 
	 * @return the evalAmont
	 */
	public String getEvalAmont() {
		return evalAmont;
	}

	/**
	 * Setter
	 * 
	 * @param evalAmont the evalAmont to set
	 */
	public void setEvalAmont(String evalAmont) {
		this.evalAmont = evalAmont;
	}

	/**
	 * Getter
	 * 
	 * @return the idPrevious
	 */
	public Long getIdPrevious() {
		return idPrevious;
	}

	/**
	 * Setter
	 * 
	 * @param idPrevious the idPrevious to set
	 */
	public void setIdPrevious(Long idPrevious) {
		this.idPrevious = idPrevious;
	}

	/**
	 * Getter
	 * 
	 * @return the idParent
	 */
	public Long getIdParent() {
		return idParent;
	}

	/**
	 * Setter
	 * 
	 * @param idParent the idParent to set
	 */
	public void setIdParent(Long idParent) {
		this.idParent = idParent;
	}

	/**
	 * Getter
	 * 
	 * @return the idNext
	 */
	public Long getIdNext() {
		return idNext;
	}

	/**
	 * Setter
	 * 
	 * @param idNext the idNext to set
	 */
	public void setIdNext(Long idNext) {
		this.idNext = idNext;
	}

	/**
	 * Setter
	 * 
	 * @param duree the duree to set
	 */
	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	/**
	 * Getter
	 * 
	 * @return the scoreObtentionCertif
	 */
	public Integer getScoreObtentionCertif() {
		return scoreObtentionCertif;
	}

	/**
	 * Setter
	 * 
	 * @param scoreObtentionCertif the scoreObtentionCertif to set
	 */
	public void setScoreObtentionCertif(Integer scoreObtentionCertif) {
		this.scoreObtentionCertif = scoreObtentionCertif;
	}

	/**
	 * Getter
	 * 
	 * @return the nbCertifsBlanches
	 */
	public Integer getNbCertifsBlanches() {
		return nbCertifsBlanches;
	}

	/**
	 * Setter
	 * 
	 * @param nbCertifsBlanches the nbCertifsBlanches to set
	 */
	public void setNbCertifsBlanches(Integer nbCertifsBlanches) {
		this.nbCertifsBlanches = nbCertifsBlanches;
	}

	/**
	 * Getter
	 * 
	 * @return the infosCertif
	 */
	public String getInfosCertif() {
		return infosCertif;
	}

	/**
	 * Setter
	 * 
	 * @param infosCertif the infosCertif to set
	 */
	public void setInfosCertif(String infosCertif) {
		this.infosCertif = infosCertif;
	}

	/**
	 * Getter
	 * 
	 * @return the preRequis
	 */
	public String getPreRequis() {
		return preRequis;
	}

	/**
	 * Setter
	 * 
	 * @param preRequis the preRequis to set
	 */
	public void setPreRequis(String preRequis) {
		this.preRequis = preRequis;
	}

	/**
	 * Getter
	 * 
	 * @return the introSyllabus
	 */
	public String getIntroSyllabus() {
		return introSyllabus;
	}

	/**
	 * Setter
	 * 
	 * @param introSyllabus the introSyllabus to set
	 */
	public void setIntroSyllabus(String introSyllabus) {
		this.introSyllabus = introSyllabus;
	}

	/**
	 * Getter
	 * 
	 * @return the nomLogoCertification
	 */
	public String getNomLogoCertification() {
		return nomLogoCertification;
	}

	/**
	 * Setter
	 * 
	 * @param nomLogoCertification the nomLogoCertification to set
	 */
	public void setNomLogoCertification(String nomLogoCertification) {
		this.nomLogoCertification = nomLogoCertification;
	}

	/**
	 * Getter
	 * 
	 * @return the nomCourt
	 */
	public String getNomCourt() {
		return nomCourt;
	}

	/**
	 * Setter
	 * 
	 * @param nomCourt the nomCourt to set
	 */
	public void setNomCourt(String nomCourt) {
		this.nomCourt = nomCourt;
	}

	/**
	 * Getter
	 * 
	 * @return the referenceExamen
	 */
	public String getReferenceExamen() {
		return referenceExamen;
	}

	/**
	 * Setter
	 * 
	 * @param referenceExamen the referenceExamen to set
	 */
	public void setReferenceExamen(String referenceExamen) {
		this.referenceExamen = referenceExamen;
	}

	/**
	 * Getter
	 * 
	 * @return the editeurCertification
	 */
	public String getEditeurCertification() {
		return editeurCertification;
	}

	/**
	 * Setter
	 * 
	 * @param editeurCertification the editeurCertification to set
	 */
	public void setEditeurCertification(String editeurCertification) {
		this.editeurCertification = editeurCertification;
	}
}
