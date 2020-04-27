package dev.domain.finance;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.domain.SessionStagiaire;

/**
 * Resencement des absences d'un stagiaire à une session de formation qui a eu lieu
 * 
 * Elles commencent à une date de début et finisse à une  date de fin.
 * Pour les dates de début et de fin on spécifie la présence à la demi-journée
 * ( matin et après midi)
 * 
 * Entre les deux dates les absences sont forcément  matin et après midi
 * 
 * Attention : 
 * Ne pas include des dates de fermeture du à des jours fériés, de fermeture de 
 * l'établissement de formation...car la formation n'a pas lieu donc le stagiaire
 * ne peut pas etre considéré comme absent
 * 
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name="ABSENCE_STAGIAIRE")
@Cacheable
public class AbsenceStagiaire {

	/** identifiant */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/** Date de début d'absence */
	@Column(name = "DATE_DEB")
	private LocalDate dateDebut;

	/** Date de fin d'absence */
	@Column(name = "DATE_FIN")
	private LocalDate dateFin;

	/** Absence Matin de date debut  */
	@Column(name = "ABS_DEBUT_MATIN")
	private boolean  absenceDebutMatin;

	/** Absence AM de date debut  */
	@Column(name = "ABS_DEBUT_APREM")
	private boolean  absenceDebutAprem;

	/** Absence Matin de date fin  */
	@Column(name = "ABS_FIN_MATIN")
	private boolean  absenceFinMatin;

	/** Absence AM de date fin  */
	@Column(name = "ABS_FIN_APREM")
	private boolean  absenceFinAprem;

	/** Motif d'absence  */
	@Column(name = "MOTIF")
	private String  motif;

	/** Session stagiaire */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="ID_SESSION", referencedColumnName="ID_SES"),
		@JoinColumn(name="ID_STAGIAIRE", referencedColumnName="ID_STAG")
	})
	SessionStagiaire sessionStagiaire ;
	

	/**
	 * 
	 */
	public AbsenceStagiaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** Getter
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/** Getter
	 * @return the absenceDebutMatin
	 */
	public boolean isAbsenceDebutMatin() {
		return absenceDebutMatin;
	}

	/** Setter
	 * @param absenceDebutMatin the absenceDebutMatin to set
	 */
	public void setAbsenceDebutMatin(boolean absenceDebutMatin) {
		this.absenceDebutMatin = absenceDebutMatin;
	}

	/** Getter
	 * @return the absenceDebutAprem
	 */
	public boolean isAbsenceDebutAprem() {
		return absenceDebutAprem;
	}

	/** Setter
	 * @param absenceDebutAprem the absenceDebutAprem to set
	 */
	public void setAbsenceDebutAprem(boolean absenceDebutAprem) {
		this.absenceDebutAprem = absenceDebutAprem;
	}

	/** Getter
	 * @return the absenceFinMatin
	 */
	public boolean isAbsenceFinMatin() {
		return absenceFinMatin;
	}

	/** Setter
	 * @param absenceFinMatin the absenceFinMatin to set
	 */
	public void setAbsenceFinMatin(boolean absenceFinMatin) {
		this.absenceFinMatin = absenceFinMatin;
	}

	/** Getter
	 * @return the absenceFinAprem
	 */
	public boolean isAbsenceFinAprem() {
		return absenceFinAprem;
	}

	/** Setter
	 * @param absenceFinAprem the absenceFinAprem to set
	 */
	public void setAbsenceFinAprem(boolean absenceFinAprem) {
		this.absenceFinAprem = absenceFinAprem;
	}

	/** Getter
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/** Setter
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/** Getter
	 * @return the sessionStagiaire
	 */
	public SessionStagiaire getSessionStagiaire() {
		return sessionStagiaire;
	}

	/** Setter
	 * @param sessionStagiaire the sessionStagiaire to set
	 */
	public void setSessionStagiaire(SessionStagiaire sessionStagiaire) {
		this.sessionStagiaire = sessionStagiaire;
	}
	

}
