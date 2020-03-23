package dev.domain.histonotation;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.domain.notation.Bulletin;

/**
 * Représente une note, un résultat à un atelier, un QCM ou une note de savoir-être
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "NOTE_HISTO")
public class NoteHisto {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** valeur : double */
	@Column(name = "VALEUR")
	private String valeur;

	/** valeur : double */
	@Column(name = "VALEUR_PREC")
	private String valeurPrecedente;

	/** critereNotation : CritereNotation */
	@Column(name = "COURS")
	private String cours;

	/** critereNotation : CritereNotation */
	@Column(name = "CRITERE")
	private String critere;

	/** stagiaire : String */
	@Column(name = "STAGIAIRE")
	private String stagiaire;

	/** session : String */
	@Column(name = "SESSION")
	private String session;

	/** bulletin : Bulletin */
	@ManyToOne
	@JoinColumn(name = "ID_BULLETIN")
	private Bulletin bulletin;

	/** userMaj : String */
	@Column(name = "USER_MAJ")
	private String userMaj;

	/** dateMaj : LocalDateTime */
	@Column(name = "DATE_MAJ")
	private LocalDateTime dateMaj;

	/** appreciation : String */
	@Column(name = "APPRECIATION")
	private String appreciation;

	/** appreciatonPrec : String */
	@Column(name = "APPRECIATION_PREC")
	private String appreciatonPrec;

	/**
	 * Constructor
	 * 
	 */
	public NoteHisto() {

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
	 * @return the valeur
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * Setter
	 * 
	 * @param valeur the valeur to set
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	/**
	 * Getter
	 * 
	 * @return the valeurPrecedente
	 */
	public String getValeurPrecedente() {
		return valeurPrecedente;
	}

	/**
	 * Setter
	 * 
	 * @param valeurPrecedente the valeurPrecedente to set
	 */
	public void setValeurPrecedente(String valeurPrecedente) {
		this.valeurPrecedente = valeurPrecedente;
	}

	/**
	 * Getter
	 * 
	 * @return the bulletin
	 */
	public Bulletin getBulletin() {
		return bulletin;
	}

	/**
	 * Setter
	 * 
	 * @param bulletin the bulletin to set
	 */
	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
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
	 * @return the appreciation
	 */
	public String getAppreciation() {
		return appreciation;
	}

	/**
	 * Setter
	 * 
	 * @param appreciation the appreciation to set
	 */
	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}

	/**
	 * Getter
	 * 
	 * @return the appreciatonPrec
	 */
	public String getAppreciatonPrec() {
		return appreciatonPrec;
	}

	/**
	 * Setter
	 * 
	 * @param appreciatonPrec the appreciatonPrec to set
	 */
	public void setAppreciatonPrec(String appreciatonPrec) {
		this.appreciatonPrec = appreciatonPrec;
	}

	/**
	 * Getter
	 * 
	 * @return the critere
	 */
	public String getCritere() {
		return critere;
	}

	/**
	 * Setter
	 * 
	 * @param critere the critere to set
	 */
	public void setCritere(String critere) {
		this.critere = critere;
	}

	/**
	 * Getter
	 * 
	 * @return the stagiaire
	 */
	public String getStagiaire() {
		return stagiaire;
	}

	/**
	 * Setter
	 * 
	 * @param stagiaire the stagiaire to set
	 */
	public void setStagiaire(String stagiaire) {
		this.stagiaire = stagiaire;
	}

	/**
	 * Getter
	 * 
	 * @return the session
	 */
	public String getSession() {
		return session;
	}

	/**
	 * Setter
	 * 
	 * @param session the session to set
	 */
	public void setSession(String session) {
		this.session = session;
	}

	/**
	 * Getter
	 * 
	 * @return the cours
	 */
	public String getCours() {
		return cours;
	}

	/**
	 * Setter
	 * 
	 * @param cours the cours to set
	 */
	public void setCours(String cours) {
		this.cours = cours;
	}
}
