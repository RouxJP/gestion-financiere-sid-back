package dev.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dev.domain.finance.AbsenceStagiaire;
import dev.domain.finance.TypeFinancementChoisi;

/**
 * Représente un couple session/stagiaire pour lequel on a accés à :
 *  - une liste de  type de financements choisis
 *  - une liste d'absences du stagiaire 
 *  
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "SESSION_STAGIAIRE")
@Cacheable
public class SessionStagiaire implements Serializable {

	private static long serialVersionUID = 1L;

	/** Session */
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SES")
	private Session  session;

	/** Utilisateur */
	@Id	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_STAG")
	private Utilisateur stagiaire;


	/** Liste des types de financements choisis pour un stagiaire à une session donnée */
	@OneToMany(mappedBy = "sessionStagiaire", fetch = FetchType.LAZY)
	private List<TypeFinancementChoisi> typesFinChoisis = new ArrayList<>();


	/** Liste des absences d'un stagiaire à une session donnée */
	@OneToMany(mappedBy = "sessionStagiaire", fetch = FetchType.LAZY)
	private List<AbsenceStagiaire> absencesStagiaires = new ArrayList<>();


	/**
	 * @param session
	 * @param stagiaire
	 * @param typesFinChoisis
	 * @param absencesStagiaires
	 */
	public SessionStagiaire(Session session, Utilisateur stagiaire, List<TypeFinancementChoisi> typesFinChoisis,
			List<AbsenceStagiaire> absencesStagiaires) {
		super();
		this.session = session;
		this.stagiaire = stagiaire;
		this.typesFinChoisis = typesFinChoisis;
		this.absencesStagiaires = absencesStagiaires;
	}


	/** Getter
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/** Setter
	 * @param serialversionuid the serialversionuid to set
	 */
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}


	/** Getter
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}


	/** Setter
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}


	/** Getter
	 * @return the stagiaire
	 */
	public Utilisateur getStagiaire() {
		return stagiaire;
	}


	/** Setter
	 * @param stagiaire the stagiaire to set
	 */
	public void setStagiaire(Utilisateur stagiaire) {
		this.stagiaire = stagiaire;
	}


	/** Getter
	 * @return the typesFinChoisis
	 */
	public List<TypeFinancementChoisi> getTypesFinChoisis() {
		return typesFinChoisis;
	}


	/** Setter
	 * @param typesFinChoisis the typesFinChoisis to set
	 */
	public void setTypesFinChoisis(List<TypeFinancementChoisi> typesFinChoisis) {
		this.typesFinChoisis = typesFinChoisis;
	}


	/** Getter
	 * @return the absencesStagiaires
	 */
	public List<AbsenceStagiaire> getAbsencesStagiaires() {
		return absencesStagiaires;
	}


	/** Setter
	 * @param absencesStagiaires the absencesStagiaires to set
	 */
	public void setAbsencesStagiaires(List<AbsenceStagiaire> absencesStagiaires) {
		this.absencesStagiaires = absencesStagiaires;
	}

	



}
