package dev.domain.finance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Représente une ligne de commande d'un bon de commande
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "LIGNE_COMMANDE")
public class LigneCommande {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** session : Session */
	@ManyToOne
	@JoinColumn(name = "ID_BON")
	private BonCommande bonCommande;

	/** libelle : String */
	@Column(name = "LIBELLE")
	private String libelle;

	/** nbJours : Integer */
	@Column(name = "NB_JOURS")
	private Integer nbJours = 0;

	/** tjm : Float */
	@Column(name = "TJM")
	private Float tjm = 0.0f;;

	/** tva : Float */
	@Column(name = "TAUX_TVA")
	private Float tauxTva = 0.0f;

	/** montantHT : Float */
	@Column(name = "MONTANT_HT")
	private Float montantHT = 0.0f;

	/** montantHT : Float */
	@Column(name = "MONTANT_TVA")
	private Float montantTVA = 0.0f;

	/** montantTTC : Float */
	@Column(name = "MONTANT_TTC")
	private Float montantTTC = 0.0f;

	/**
	 * Constructor
	 * 
	 */
	public LigneCommande() {

	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof LigneCommande)) {
			return false;
		}
		LigneCommande other = (LigneCommande) object;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
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
	 * @return the bonCommande
	 */
	public BonCommande getBonCommande() {
		return bonCommande;
	}

	/**
	 * Setter
	 * 
	 * @param bonCommande the bonCommande to set
	 */
	public void setBonCommande(BonCommande bonCommande) {
		this.bonCommande = bonCommande;
	}

	/**
	 * Getter
	 * 
	 * @return the nbJours
	 */
	public Integer getNbJours() {
		return nbJours;
	}

	/**
	 * Setter
	 * 
	 * @param nbJours the nbJours to set
	 */
	public void setNbJours(Integer nbJours) {
		this.nbJours = nbJours;
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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

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
	 * @return the montantHT
	 */
	public Float getMontantHT() {
		return montantHT;
	}

	/**
	 * Setter
	 * 
	 * @param montantHT the montantHT to set
	 */
	public void setMontantHT(Float montantHT) {
		this.montantHT = montantHT;
	}

	/**
	 * Getter
	 * 
	 * @return the montantTTC
	 */
	public Float getMontantTTC() {
		return montantTTC;
	}

	/**
	 * Setter
	 * 
	 * @param montantTTC the montantTTC to set
	 */
	public void setMontantTTC(Float montantTTC) {
		this.montantTTC = montantTTC;
	}

	/**
	 * Getter
	 * 
	 * @return the montantTVA
	 */
	public Float getMontantTVA() {
		return montantTVA;
	}

	/**
	 * Setter
	 * 
	 * @param montantTVA the montantTVA to set
	 */
	public void setMontantTVA(Float montantTVA) {
		this.montantTVA = montantTVA;
	}

}
