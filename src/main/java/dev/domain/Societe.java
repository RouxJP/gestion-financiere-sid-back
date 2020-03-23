package dev.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Représente une société
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "SOCIETE")
@Cacheable(value = true)
public class Societe {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** nom : String */
	@Column(name = "NOM")
	private String nom;

	/** adresse : String */
	@Column(name = "ADRESSE")
	private String adresse;

	/** complementAdresse : String */
	@Column(name = "COMPLEMENT_ADRESSE")
	private String complementAdresse;

	/** codePostal : Integer */
	@Column(name = "CODE_POSTAL")
	private Integer codePostal;

	/** ville : String */
	@Column(name = "VILLE")
	private String ville;

	/** siret : String */
	@Column(name = "SIRET")
	private String siret;

	/** siret : String */
	@Column(name = "NUMERO_OF")
	private String numeroOF;

	/** tvaIntraComm : String */
	@Column(name = "TVA_INTRA_COMM")
	private String tvaIntraComm;

	/** tauxTva : Float */
	@Column(name = "TAUX_TVA")
	private Float tauxTva;

	/** tjm : Integer */
	@Column(name = "TJM")
	private Float tjm;

	/** modalitesPaiement : String */
	@Column(name = "MODALITES_PAIEMENT")
	private String modalitesPaiement;

	/** utilisateurs : List de Utilisateur */
	@OneToMany(mappedBy = "societe")
	private List<Utilisateur> utilisateurs = new ArrayList<>();

	/** sessions : List de Session */
	@OneToMany(mappedBy = "societe")
	private List<Session> sessions = new ArrayList<>();

	/** responsable : Utilisateur */
	@Column(name = "RESPONSABLE")
	private String responsable;

	/** nomLogo : String */
	@Column(name = "NOM_LOGO")
	private String nomLogo;

	/** urlSiteInternet : String */
	@Column(name = "URL_SITE_INTERNET")
	private String urlSiteInternet;

	/** demandeurEmploi : Boolean */
	@Column(name = "DEMANDEUR_EMPLOI")
	private Boolean demandeurEmploi;

	/**
	 * Constructor
	 * 
	 */
	public Societe() {

	}

	/**
	 * Constructor
	 * 
	 * @param nom nom de la société
	 */
	public Societe(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * Constructor
	 * 
	 * @param id identifiant de la société
	 * @param nom nom de la société
	 */
	public Societe(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nom).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Societe)) {
			return false;
		}
		Societe other = (Societe) obj;
		return new EqualsBuilder().append(this.nom, other.getNom()).isEquals();
	}

	/**
	 * Retourne l'adresse complète au format souhaité.
	 * 
	 * @param separator séparateur de formattage
	 * @return String
	 */
	public String getAdresseComplete(String separator) {
		StringBuilder adresseSociete = new StringBuilder();
		adresseSociete.append(nom);
		if (StringUtils.isNotEmpty(adresse)) {
			adresseSociete.append(separator).append(adresse);
		}
		if (codePostal != null) {
			adresseSociete.append(separator).append(codePostal);
		}
		if (StringUtils.isNotEmpty(ville)) {
			adresseSociete.append(separator).append(ville);
		}
		return adresseSociete.toString();
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
	 * Getter
	 * 
	 * @return the utilisateurs
	 */
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * Setter
	 * 
	 * @param utilisateurs the utilisateurs to set
	 */
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	/**
	 * Getter
	 * 
	 * @return the sesions
	 */
	public List<Session> getSessions() {
		return sessions;
	}

	/**
	 * Setter
	 * 
	 * @param sessions the sessions to set
	 */
	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	/**
	 * Getter
	 * 
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Setter
	 * 
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter
	 * 
	 * @return the siret
	 */
	public String getSiret() {
		return siret;
	}

	/**
	 * Setter
	 * 
	 * @param siret the siret to set
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}

	/**
	 * Getter
	 * 
	 * @return the tvaIntraComm
	 */
	public String getTvaIntraComm() {
		return tvaIntraComm;
	}

	/**
	 * Setter
	 * 
	 * @param tvaIntraComm the tvaIntraComm to set
	 */
	public void setTvaIntraComm(String tvaIntraComm) {
		this.tvaIntraComm = tvaIntraComm;
	}

	/**
	 * Getter
	 * 
	 * @return the tjm
	 */
	public Float getTjm() {
		return tjm;
	}

	/**
	 * Setter
	 * 
	 * @param tjm the tjm to set
	 */
	public void setTjm(Float tjm) {
		this.tjm = tjm;
	}

	/**
	 * Getter
	 * 
	 * @return the responsable
	 */
	public String getResponsable() {
		return responsable;
	}

	/**
	 * Setter
	 * 
	 * @param responsable the responsable to set
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	/**
	 * Getter
	 * 
	 * @return the codePostal
	 */
	public Integer getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter
	 * 
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter
	 * 
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter
	 * 
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Getter
	 * 
	 * @return the complementAdresse
	 */
	public String getComplementAdresse() {
		return complementAdresse;
	}

	/**
	 * Setter
	 * 
	 * @param complementAdresse the complementAdresse to set
	 */
	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	/**
	 * Getter
	 * 
	 * @return the nomLogo
	 */
	public String getNomLogo() {
		return nomLogo;
	}

	/**
	 * Setter
	 * 
	 * @param nomLogo the nomLogo to set
	 */
	public void setNomLogo(String nomLogo) {
		this.nomLogo = nomLogo;
	}

	/**
	 * Getter
	 * 
	 * @return the urlSiteInternet
	 */
	public String getUrlSiteInternet() {
		return urlSiteInternet;
	}

	/**
	 * Setter
	 * 
	 * @param urlSiteInternet the urlSiteInternet to set
	 */
	public void setUrlSiteInternet(String urlSiteInternet) {
		this.urlSiteInternet = urlSiteInternet;
	}

	/**
	 * Getter
	 * 
	 * @return the tauxTva
	 */
	public Float getTauxTva() {
		return tauxTva;
	}

	/**
	 * Setter
	 * 
	 * @param tauxTva the tauxTva to set
	 */
	public void setTauxTva(Float tauxTva) {
		this.tauxTva = tauxTva;
	}

	/**
	 * Getter
	 * 
	 * @return the modalitesPaiement
	 */
	public String getModalitesPaiement() {
		return modalitesPaiement;
	}

	/**
	 * Setter
	 * 
	 * @param modalitesPaiement the modalitesPaiement to set
	 */
	public void setModalitesPaiement(String modalitesPaiement) {
		this.modalitesPaiement = modalitesPaiement;
	}

	/**
	 * Getter
	 * 
	 * @return the numeroOF
	 */
	public String getNumeroOF() {
		return numeroOF;
	}

	/**
	 * Setter
	 * 
	 * @param numeroOF the numeroOF to set
	 */
	public void setNumeroOF(String numeroOF) {
		this.numeroOF = numeroOF;
	}

	/**
	 * Getter
	 * 
	 * @return the demandeurEmploi
	 */
	public Boolean getDemandeurEmploi() {
		return demandeurEmploi;
	}

	/**
	 * Setter
	 * 
	 * @param demandeurEmploi the demandeurEmploi to set
	 */
	public void setDemandeurEmploi(Boolean demandeurEmploi) {
		this.demandeurEmploi = demandeurEmploi;
	}

}
