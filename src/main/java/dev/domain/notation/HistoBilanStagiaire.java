package dev.domain.notation;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Représente un bilan mensuel stagiaire
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "HISTO_BILAN_STAGIAIRE")
public class HistoBilanStagiaire {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	/** datePrevue : LocalDate */
	@Column(name = "DATE_PREVUE")
	private LocalDate datePrevue;

	/** dateEffective : LocalDate */
	@Column(name = "DATE_EFFECTIVE")
	private LocalDate dateEffective;

	/** numero : int */
	@Column(name = "NUMERO")
	private int numero;

	/** appreciation : String */
	@Column(name = "APPRECIATION")
	private String appreciation;

	/** indiceConfiance : int */
	@Column(name = "INDICE_CONFIANCE")
	private int indiceConfiance;

	/** email : String */
	@Column(name = "EMAIL")
	private String email;

	/** nomStagiaire : String */
	@Column(name = "NOM_STAGIAIRE")
	private String nomStagiaire;

	/** prenomStagiaire : String */
	@Column(name = "PRENOM_STAGIAIRE")
	private String prenomStagiaire;

	/** nomSession : String */
	@Column(name = "NOM_SESSION")
	private String nomSession;

	/** userMaj : String */
	@Column(name = "USER_MAJ")
	private String userMaj;

	/** dateMaj : LocalDateTime */
	@Column(name = "DATE_MAJ")
	private LocalDateTime dateMaj;

	/**
	 * Constructor par défaut<br/>
	 * Obligatoire pour JPA
	 */
	public HistoBilanStagiaire() {

	}

	/**
	 * Constructor
	 * 
	 * @param bilan bilan stagiaire
	 */
	public HistoBilanStagiaire(BilanStagiaire bilan) {
		this.appreciation = bilan.getAppreciation();
		this.dateEffective = bilan.getDateEffective();
		this.datePrevue = bilan.getDatePrevue();
		this.dateMaj = LocalDateTime.now();
		this.indiceConfiance = bilan.getIndiceConfiance();
		if (bilan.getBulletin() != null) {
			if (bilan.getBulletin().getSession() != null) {
				this.nomSession = bilan.getBulletin().getSession().getNom();
			}
			if (bilan.getBulletin().getUtilisateur() != null) {
				this.email = bilan.getBulletin().getUtilisateur().getEmail();
				this.nomStagiaire = bilan.getBulletin().getUtilisateur().getNom();
				this.prenomStagiaire = bilan.getBulletin().getUtilisateur().getPrenom();
			}
		}
		this.numero = bilan.getNumero();
	}

	/**
	 * Getter
	 * 
	 * @return the indiceConfiance
	 */
	public int getIndiceConfiance() {
		return indiceConfiance;
	}

	/**
	 * Setter
	 * 
	 * @param indiceConfiance the indiceConfiance to set
	 */
	public void setIndiceConfiance(int indiceConfiance) {
		this.indiceConfiance = indiceConfiance;
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
	 * @return the datePrevue
	 */
	public LocalDate getDatePrevue() {
		return datePrevue;
	}

	/**
	 * Setter
	 * 
	 * @param datePrevue the datePrevue to set
	 */
	public void setDatePrevue(LocalDate datePrevue) {
		this.datePrevue = datePrevue;
	}

	/**
	 * Getter
	 * 
	 * @return the dateEffective
	 */
	public LocalDate getDateEffective() {
		return dateEffective;
	}

	/**
	 * Setter
	 * 
	 * @param dateEffective the dateEffective to set
	 */
	public void setDateEffective(LocalDate dateEffective) {
		this.dateEffective = dateEffective;
	}

	/**
	 * Getter
	 * 
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Setter
	 * 
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
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
	 * @return the nomStagiaire
	 */
	public String getNomStagiaire() {
		return nomStagiaire;
	}

	/**
	 * Setter
	 * 
	 * @param nomStagiaire the nomStagiaire to set
	 */
	public void setNomStagiaire(String nomStagiaire) {
		this.nomStagiaire = nomStagiaire;
	}

	/**
	 * Getter
	 * 
	 * @return the prenomStagiaire
	 */
	public String getPrenomStagiaire() {
		return prenomStagiaire;
	}

	/**
	 * Setter
	 * 
	 * @param prenomStagiaire the prenomStagiaire to set
	 */
	public void setPrenomStagiaire(String prenomStagiaire) {
		this.prenomStagiaire = prenomStagiaire;
	}

	/**
	 * Getter
	 * 
	 * @return the nomSession
	 */
	public String getNomSession() {
		return nomSession;
	}

	/**
	 * Setter
	 * 
	 * @param nomSession the nomSession to set
	 */
	public void setNomSession(String nomSession) {
		this.nomSession = nomSession;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
