package dev.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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

import dev.domain.finance.AbsenceStagiaire;
import dev.domain.finance.TypeFinancementChoisi;

/**
 * Représente un couple session/stagiaire pour lequel on a accés à :
 *  - une liste de  type de financements choisis
 *  - une liste d'absences du stagiaire 
 *  
 * @author JP ROUX
 *
 */
@Entity
@Table(name = "SESSION_STAGIAIRE")
@Cacheable
public class SessionStagiaire implements Serializable{

	private static long serialVersionUID = 1L;

	/** identifiant */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/** Session */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SES")
	private Session  session;

	/** Utilisateur */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_STAG")
	private Utilisateur stagiaire;


	/** Liste des types de financements choisis pour un stagiaire à une session donnée */
	@OneToMany(mappedBy = "sessionStagiaire", fetch = FetchType.LAZY)
	private List<TypeFinancementChoisi> typesFinChoisis = new ArrayList<>();


	/** Liste des absences d'un stagiaire à une session donnée */
	@OneToMany(mappedBy = "sessionStagiaire", fetch = FetchType.LAZY)
	private List<AbsenceStagiaire> absencesStagiaires = new ArrayList<>();

	
	/** DEBUT : Zone de Calculs */
	/**
	 * Calculer les absences entre deux dates
	 * 
	 * @param 
	 * dateDebut : date de calcul de début d'absence
	 * dateFin   : date de calcul de fin   d'absence
	 */
	public float calcAbsences( LocalDate dateDebut, LocalDate dateFin ) {
		/** TODO */
		return 0;
	}
	
	/**
	 * Calcule le CA HT des type de financement choisi pour un stagiaire
	 * d'une session
	 * 
	 * @return
	 */
	public float calc_CA_HT_typeFinChoisiStagiaire() {
		float ca_HT_total = 0.0f ;
		for( TypeFinancementChoisi typeFinChoisi : typesFinChoisis ) {
			ca_HT_total += typeFinChoisi.calc_CA_HT_typeFinChoisi() ;
		}
		return ca_HT_total;
	}
	/** FIN : Zone de Calculs */

	/**
	 * 
	 */
	public SessionStagiaire() {
		super();
		// TODO Auto-generated constructor stub
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
