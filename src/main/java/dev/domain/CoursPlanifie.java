package dev.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.HashCodeBuilder;
//import org.dgn.planification.sessions.StatutValidation;

/**
 * Représente un cours planifié pour une session donnée
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "COURS_PLANIFIE")
public class CoursPlanifie implements Evenement {

	/** identifiant */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/** libelle : String */
	@Column(name = "LIBELLE")
	private String libelle;

	/** duree : int */
	@Column(name = "DUREE")
	private int duree;

	/** Coefficient pour la notation */
	@Column(name = "COEFF")
	private int coefficient;

	/** Date de début du cours pour la session */
	@Column(name = "DATE_DEBUT")
	private LocalDate dateDebut;

	/** Date de fin du cours pour la session */
	@Column(name = "DATE_FIN")
	private LocalDate dateFin;

	/** Cours modèle */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COU")
	private Cours cours;

	/** Formateur qui donne le cours */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FORMATEUR")
	private Utilisateur formateur;

	/**
	 * Salle d'informatique dans laquelle aura lieu le cours: par défaut c'est la
	 * salle de la session.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SAL")
	private Salle salle;

	/** Session associée */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SES")
	private Session session;

	/** formateurDispo : boolean */
	@Column(name = "FORMATEUR_DISPO")
	private boolean formateurDispo;

	/** salleDispo : boolean */
	@Column(name = "SALLE_DISPO")
	private boolean salleDispo;

	/** statutValidation : StatutValidation */
	@Column(name = "STATUT_VALIDATION")
	@Enumerated(EnumType.STRING)
	private StatutValidation statutValidation;

	/** commentaires : String */
	@Column(name = "COMMENTAIRES")
	private String commentaires;

	/** formateursDisponibles : List de Utilisateur */
	@Transient
	private List<Utilisateur> formateursDisponibles = new ArrayList<>();

	/** modalité pédagogique à laquelle le cours appartient */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MODALITE_PEDAGOGIQUE")
	private ModalitePedagogique modalitePedagogique;

	/**
	 * Constructeur
	 */
	public CoursPlanifie() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param libelle   libellé
	 * @param dateDebut date de début
	 * @param dateFin   date de fin
	 * @param session   session
	 */
	public CoursPlanifie(String libelle, LocalDate dateDebut, LocalDate dateFin, Session session) {
		super();
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.session = session;
	}

	/**
	 * Constructeur
	 * 
	 * @param id        identifiant
	 * @param libelle   libellé
	 * @param dateDebut date de début
	 * @param dateFin   date de fin
	 * @param session   session
	 */
	public CoursPlanifie(Long id, String libelle, LocalDate dateDebut, LocalDate dateFin, Session session) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.session = session;
	}

	/**
	 * Constructor
	 * 
	 * @param id          identifiant
	 * @param libelle     libellé
	 * @param coefficient coefficient
	 * @param dateDebut   date de début
	 * @param dateFin     date de fin
	 * @param cours       cours
	 * @param formateur   formateur
	 */
	public CoursPlanifie(Long id, String libelle, int coefficient, LocalDate dateDebut, LocalDate dateFin, Cours cours,
			Utilisateur formateur) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.coefficient = coefficient;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.cours = cours;
		this.formateur = formateur;
	}
/**
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CoursPlanifie)) {
			return false;
		}
		CoursPlanifie other = (CoursPlanifie) obj;
		return new EqualsBuilder().append(libelle, other.getLibelle()).append(dateDebut, other.getDateDebut())
				.append(dateFin, other.getDateFin()).append(formateur, other.getFormateur()).isEquals();
	}
**/
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(libelle).append(dateDebut).append(dateFin).append(formateur).toHashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CoursPlanifie [libelle=" + libelle + ", duree=" + duree + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", formateur=" + formateur + ", salle=" + salle + "]";
	}

	/*
	@Override
	public String getAttribut1() {
		return Integer.toString(coefficient);
	}
	*/
	
	@Override
	public String getNom() {
		return libelle;
	}

	@Override
	public String getRessource() {
		return session.getNom();
	}

	@Override
	public TypeEvenement getType() {
		return TypeEvenement.COURS;
	}

	@Override
	public Centre getCentre() {
		return session.getCentre();
	}

	/**
	 * Getter for id
	 * 
	 * @return the id
	 */
	@Override
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
	 * Getter for dateDebut
	 * 
	 * @return the dateDebut
	 */
	@Override
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Getter for dateFin
	 * 
	 * @return the dateFin
	 */
	@Override
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
	 * Getter for session
	 * 
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * Setter
	 * 
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
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
	 * @param cours the cours to set
	 */
	public void setCours(Cours cours) {
		this.cours = cours;
	}

	/**
	 * Getter for coefficient
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
/*
	@Override
	public Utilisateur getIntervenant() {
		return formateur;
	}
*/
	/**
	 * Getter for formateur
	 * 
	 * @return the formateur
	 */
	public Utilisateur getFormateur() {
		return formateur;
	}

	/**
	 * Setter
	 * 
	 * @param formateur the formateur to set
	 */
	public void setFormateur(Utilisateur formateur) {
		this.formateur = formateur;
	}

	/**
	 * Getter
	 * 
	 * @return the salle
	 */
	public Salle getSalle() {
		return salle;
	}

	/**
	 * Setter
	 * 
	 * @param salle the salle to set
	 */
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
/*	
	@Override
	public String getLibelle() {
		return libelle;
	}
*/
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
	 * @return the duree
	 */
/*	
	@Override
	public int getDuree() {
		return duree;
	}
*/
	/**
	 * Setter
	 * 
	 * @param duree the duree to set
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * Getter
	 * 
	 * @return the formateurDispo
	 */
	public Boolean isFormateurDispo() {
		return formateurDispo;
	}

	/**
	 * Setter
	 * 
	 * @param formateurDispo the formateurDispo to set
	 */
	public void setFormateurDispo(boolean formateurDispo) {
		this.formateurDispo = formateurDispo;
	}

	/**
	 * Getter
	 * 
	 * @return the salleDispo
	 */
	public boolean isSalleDispo() {
		return salleDispo;
	}

	/**
	 * Setter
	 * 
	 * @param salleDispo the salleDispo to set
	 */
	public void setSalleDispo(boolean salleDispo) {
		this.salleDispo = salleDispo;
	}

	/**
	 * Getter
	 * 
	 * @return the statutValidation
	 */
	@Override
	public StatutValidation getStatutValidation() {
		return statutValidation;
	}

	/**
	 * Setter
	 * 
	 * @param statutValidation the statutValidation to set
	 */
	public void setStatutValidation(StatutValidation statutValidation) {
		this.statutValidation = statutValidation;
	}

	/**
	 * Getter
	 * 
	 * @return the commentaires
	 */
	public String getCommentaires() {
		return commentaires;
	}

	/**
	 * Setter
	 * 
	 * @param commentaires the commentaires to set
	 */
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	/**
	 * Getter
	 * 
	 * @return the formateursDisponibles
	 */
	public List<Utilisateur> getFormateursDisponibles() {
		return formateursDisponibles;
	}

	/**
	 * Setter
	 * 
	 * @param formateursDisponibles the formateursDisponibles to set
	 */
	public void setFormateursDisponibles(List<Utilisateur> formateursDisponibles) {
		this.formateursDisponibles = formateursDisponibles;
	}

	/**
	 * Getter
	 * 
	 * @return the modalitePedagogique
	 */
/*	
	@Override
	public ModalitePedagogique getModalitePedagogique() {
		return modalitePedagogique;
	}
*/
	/**
	 * Setter
	 * 
	 * @param modalitePedagogique the modalitePedagogique to set
	 */
	public void setModalitePedagogique(ModalitePedagogique modalitePedagogique) {
		this.modalitePedagogique = modalitePedagogique;
	}

	/**
	 * Classe qui construit des instances de {@link CoursPlanifie}
	 * 
	 * @author DIGINAMIC
	 *
	 */
	public static class CoursPlanifieBuilder {

		/**
		 * Construit une nouvelle instance de cours planifié à partir d'une instance
		 * passée en paramètre
		 * 
		 * @param origin origine
		 * @return {@link CoursPlanifie}
		 */
		public static CoursPlanifie getInstance(CoursPlanifie origin) {
			CoursPlanifie coursPlanifie = new CoursPlanifie();
			coursPlanifie.setId(origin.getId());
//			coursPlanifie.setLibelle(origin.getLibelle());
			coursPlanifie.setCoefficient(origin.getCoefficient());
//			coursPlanifie.setDuree(origin.getDuree());
			coursPlanifie.setDateDebut(origin.getDateDebut());
			coursPlanifie.setDateFin(origin.getDateFin());
			coursPlanifie.setFormateur(origin.getFormateur());
			coursPlanifie.setFormateurDispo(origin.isFormateurDispo());
			coursPlanifie.setSalle(origin.getSalle());
			coursPlanifie.setSalleDispo(origin.isSalleDispo());
			coursPlanifie.setCours(origin.getCours());
			coursPlanifie.setStatutValidation(origin.getStatutValidation());
			coursPlanifie.setCommentaires(origin.getCommentaires());
//			coursPlanifie.setModalitePedagogique(origin.getModalitePedagogique());
			return coursPlanifie;
		}

		/**
		 * Construit une instance de cours planifié à partir d'un cours, d'une salle et
		 * d'un statut de validation
		 * 
		 * @param cours  cours
		 * @param salle  salle
		 * @param statut statut de validation
		 * @return {@link CoursPlanifie}
		 */
		public static CoursPlanifie getInstance(Cours cours, Salle salle, StatutValidation statut) {
			CoursPlanifie coursPlanifie = new CoursPlanifie();
			coursPlanifie.setSalle(salle);
			coursPlanifie.setLibelle(cours.getLibelle());
			coursPlanifie.setCoefficient(cours.getCoefficient());
			coursPlanifie.setDuree(cours.getDuree());
			coursPlanifie.setCours(cours);
			coursPlanifie.setStatutValidation(statut);
			coursPlanifie.setModalitePedagogique(cours.getModalitePedagogique());
			return coursPlanifie;
		}
	}

}
