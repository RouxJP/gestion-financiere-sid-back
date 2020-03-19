package dev.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Représente un Centre (lieu) où des formations sont organisées
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "CENTRE")
@Cacheable(value = true)
public class Centre {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/** nom : String */
	@Column(name = "NOM")
	private String nom;

	/** adresse : String */
	@Column(name = "ADRESSE")
	private String adresse;

	/** responsable : String */
	@Column(name = "RESPONSABLE")
	private String responsable;

	/** mailResponsableAdmin : String */
	@Column(name = "MAIL_RESPONSABLE_ADMIN")
	private String mailResponsableAdmin;

	/**
	 * titre du responsable (exemple Directeur, Responsable pédagogique, etc.)
	 */
	@Column(name = "QUALITE")
	private String qualite;

	/**
	 * Nom de l'image (signature numérisée) à insérer dans les documents
	 * administratifs
	 */
	@Column(name = "NOM_IMAGE_SIGNATURE")
	private String nomImageSignature;

	/**
	 * Constructeur
	 */
	public Centre() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 *            identifiant du centre
	 * @param nom
	 *            nom du centre
	 */
	public Centre(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	/**
	 * Constructeur
	 * 
	 * @param nom
	 *            nom du centre
	 */
	public Centre(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Centre)) {
			return false;
		}
		Centre other = (Centre) obj;
		return new EqualsBuilder().append(nom, other.getNom()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nom).toHashCode();
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
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter for adresse
	 * 
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Setter
	 * 
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter for responsable
	 * 
	 * @return the responsable
	 */
	public String getResponsable() {
		return responsable;
	}

	/**
	 * Setter
	 * 
	 * @param responsable
	 *            the responsable to set
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	/**
	 * Getter
	 * 
	 * @return the qualite
	 */
	public String getQualite() {
		return qualite;
	}

	/**
	 * Setter
	 * 
	 * @param qualite
	 *            the qualite to set
	 */
	public void setQualite(String qualite) {
		this.qualite = qualite;
	}

	/**
	 * Getter
	 * 
	 * @return the nomImageSignature
	 */
	public String getNomImageSignature() {
		return nomImageSignature;
	}

	/**
	 * Setter
	 * 
	 * @param nomImageSignature
	 *            the nomImageSignature to set
	 */
	public void setNomImageSignature(String nomImageSignature) {
		this.nomImageSignature = nomImageSignature;
	}

	/**
	 * Getter
	 * 
	 * @return the mailResponsableAdmin
	 */
	public String getMailResponsableAdmin() {
		return mailResponsableAdmin;
	}

	/**
	 * Setter
	 * 
	 * @param mailResponsableAdmin
	 *            the mailResponsableAdmin to set
	 */
	public void setMailResponsableAdmin(String mailResponsableAdmin) {
		this.mailResponsableAdmin = mailResponsableAdmin;
	}
}
