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

import dev.domain.finance.TypeFinancementChoisi;

/**
 * Représente un couple session/stagiaire pour lequel on a :
 *  - un id de financement choisi
 *  - un id d'absences du stagiaire pour ce type de financement
 *  
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "SESSION_STAGIAIRE")
@Cacheable
public class SessionStagiaire implements Serializable {


	private static final long serialVersionUID = 1L;

	/** identifiant */ 
//	@Id
//	@JoinColumn
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID")
//	private Long id;

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


	/** Liste des financements choisis pour un stagiaire à une session donnée */
	@OneToMany(mappedBy = "sessionStagiaire", fetch = FetchType.LAZY)
	private List<TypeFinancementChoisi> typesFinChoisis = new ArrayList<>();


	/** Liste des absences d'un stagiaire à une session donnée */
//	@OneToMany(mappedBy = "SESSION_STAGIAIRE", fetch = FetchType.LAZY)
//	private List<AbsenceStagiaire> absencesStagiaires = new ArrayList<>();

	
//	/** Getter
//	 * @return the typesFinChoisis
//	 */
//	public List<TypeFinancementChoisi> getTypesFinChoisis() {
//		return typesFinChoisis;
//	}
//
//	/** Setter
//	 * @param typesFinChoisis the typesFinChoisis to set
//	 */
//	public void setTypesFinChoisis(List<TypeFinancementChoisi> typesFinChoisis) {
//		this.typesFinChoisis = typesFinChoisis;
//	}

//	/** Getter
//	 * @return the absencesStagiaires
//	 */
//	public List<AbsenceStagiaire> getAbsencesStagiaires() {
//		return absencesStagiaires;
//	}
//
//	/** Setter
//	 * @param absencesStagiaires the absencesStagiaires to set
//	 */
//	public void setAbsencesStagiaires(List<AbsenceStagiaire> absencesStagiaires) {
//		this.absencesStagiaires = absencesStagiaires;
//	}
//

	/**
	 * @param id
	 * @param session
	 * @param stagiaire
	 * @param typesFinChoisis
	 */
	public SessionStagiaire(Long id, Session session, Utilisateur stagiaire,
			List<TypeFinancementChoisi> typesFinChoisis) {
		super();
//		this.id = id;
		this.session = session;
		this.stagiaire = stagiaire;
		this.typesFinChoisis = typesFinChoisis;
	}



//	/** Getter
//	 * @return the id
//	 */
//	public Long getId() {
//		return id;
//	}
//
//
//	/** Setter
//	 * @param id the id to set
//	 */
//	public void setId(Long id) {
//		this.id = id;
//	}


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



}
