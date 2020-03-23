package dev.domain.emargement;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
import javax.persistence.Transient;

import dev.domain.CoursPlanifie;
import dev.domain.Utilisateur;

/**
 * Représente un émargement à une date donnée (2 demi-journées). Il est associé
 * à un stagiaire, une session, un formateur et un cours planifié donné.
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "EMARGEMENT")
@Cacheable(value = true)
public class Emargement {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** date : LocalDateTime */
	@Column(name = "DATE_JOUR")
	private LocalDate dateJour;

	/** statutMatin : statut matin (absent, présent) */
	@Column(name = "STATUT_MATIN")
	private String statutMatin;

	/** motifAbsenceMatin : motif absence matin (facultatif) */
	@Column(name = "MOTIF_ABS_MATIN")
	private String motifAbsenceMatin;

	/** dateEmargeMatin : date d'émargement du matin */
	@Column(name = "DATE_EMAR_MATIN")
	private LocalDateTime dateEmargeMatin;

	/** statutAprem : statut après-midi (absent, présent) */
	@Column(name = "STATUT_APREM")
	private String statutAprem;

	/** motifAbsenceAprem : motif absence après-midi (facultatif) */
	@Column(name = "MOTIF_ABS_APREM")
	private String motifAbsenceAprem;

	/** dateEmargeAprem : date d'émargement de l'après-midi */
	@Column(name = "DATE_EMAR_APREM")
	private LocalDateTime dateEmargeAprem;

	/** stagiaire ou formateur */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UTILISATEUR")
	private Utilisateur utilisateur;

	/** idSessionParent : identifiant parent de la session */
	@Column(name = "ID_SESSION_PARENT")
	private Long idSessionParent;

	/** coursPlanifie : CoursPlanifie */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COURS")
	private CoursPlanifie coursPlanifie;

	/** formateur : Boolean */
	@Transient
	private Boolean formateur;

	/** disponible : Boolean */
	@Transient
	private Boolean disponible;

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
	 * @return the dateJour
	 */
	public LocalDate getDateJour() {
		return dateJour;
	}

	/**
	 * Setter
	 * 
	 * @param dateJour the dateJour to set
	 */
	public void setDateJour(LocalDate dateJour) {
		this.dateJour = dateJour;
	}

	/**
	 * Getter
	 * 
	 * @return the statutMatin
	 */
	public String getStatutMatin() {
		return statutMatin;
	}

	/**
	 * Setter
	 * 
	 * @param statutMatin the statutMatin to set
	 */
	public void setStatutMatin(String statutMatin) {
		this.statutMatin = statutMatin;
	}

	/**
	 * Getter
	 * 
	 * @return the dateEmargeMatin
	 */
	public LocalDateTime getDateEmargeMatin() {
		return dateEmargeMatin;
	}

	/**
	 * Setter
	 * 
	 * @param dateEmargeMatin the dateEmargeMatin to set
	 */
	public void setDateEmargeMatin(LocalDateTime dateEmargeMatin) {
		this.dateEmargeMatin = dateEmargeMatin;
	}

	/**
	 * Getter
	 * 
	 * @return the statutAprem
	 */
	public String getStatutAprem() {
		return statutAprem;
	}

	/**
	 * Setter
	 * 
	 * @param statutAprem the statutAprem to set
	 */
	public void setStatutAprem(String statutAprem) {
		this.statutAprem = statutAprem;
	}

	/**
	 * Getter
	 * 
	 * @return the dateEmargeAprem
	 */
	public LocalDateTime getDateEmargeAprem() {
		return dateEmargeAprem;
	}

	/**
	 * Setter
	 * 
	 * @param dateEmargeAprem the dateEmargeAprem to set
	 */
	public void setDateEmargeAprem(LocalDateTime dateEmargeAprem) {
		this.dateEmargeAprem = dateEmargeAprem;
	}

	/**
	 * Getter
	 * 
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * Setter
	 * 
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * Getter
	 * 
	 * @return the coursPlanifie
	 */
	public CoursPlanifie getCoursPlanifie() {
		return coursPlanifie;
	}

	/**
	 * Setter
	 * 
	 * @param coursPlanifie the coursPlanifie to set
	 */
	public void setCoursPlanifie(CoursPlanifie coursPlanifie) {
		this.coursPlanifie = coursPlanifie;
	}

	/**
	 * Getter
	 * 
	 * @return the motifAbsenceMatin
	 */
	public String getMotifAbsenceMatin() {
		return motifAbsenceMatin;
	}

	/**
	 * Setter
	 * 
	 * @param motifAbsenceMatin the motifAbsenceMatin to set
	 */
	public void setMotifAbsenceMatin(String motifAbsenceMatin) {
		this.motifAbsenceMatin = motifAbsenceMatin;
	}

	/**
	 * Getter
	 * 
	 * @return the motifAbsenceAprem
	 */
	public String getMotifAbsenceAprem() {
		return motifAbsenceAprem;
	}

	/**
	 * Setter
	 * 
	 * @param motifAbsenceAprem the motifAbsenceAprem to set
	 */
	public void setMotifAbsenceAprem(String motifAbsenceAprem) {
		this.motifAbsenceAprem = motifAbsenceAprem;
	}

	/**
	 * Getter
	 * 
	 * @return the formateur
	 */
	public Boolean getFormateur() {
		return formateur;
	}

	/**
	 * Setter
	 * 
	 * @param formateur the formateur to set
	 */
	public void setFormateur(Boolean formateur) {
		this.formateur = formateur;
	}

	/**
	 * Getter
	 * 
	 * @return the disponible
	 */
	public Boolean getDisponible() {
		return disponible;
	}

	/**
	 * Setter
	 * 
	 * @param disponible the disponible to set
	 */
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * Getter
	 * 
	 * @return the idSessionParent
	 */
	public Long getIdSessionParent() {
		return idSessionParent;
	}

	/**
	 * Setter
	 * 
	 * @param idSessionParent the idSessionParent to set
	 */
	public void setIdSessionParent(Long idSessionParent) {
		this.idSessionParent = idSessionParent;
	}
}
