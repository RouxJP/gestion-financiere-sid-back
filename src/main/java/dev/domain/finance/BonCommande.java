package dev.domain.finance;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import dev.domain.Session;
import dev.domain.Societe;

/**
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "BON_COMMANDE")
public class BonCommande {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** session : Session */
	@ManyToOne
	@JoinColumn(name = "ID_SESSION")
	private Session session;

	/** societe : Societe */
	@ManyToOne
	@JoinColumn(name = "ID_SOCIETE")
	private Societe societe;

	/** lignes : List de LigneCommande */
	@OneToMany(mappedBy = "bonCommande")
	private List<LigneCommande> lignes;

	/** modalitesPaiement : String */
	@Column(name = "MODALITES_PAIEMENT")
	private String modalitesPaiement;

	/** duree : Integer */
	@Column(name = "NB_JOURS")
	private Integer nbJours;

	/** Date de dernière mise à jour */
	@Column(name = "DATE_MAJ")
	private LocalDateTime dateMaj;

	/** Auteur de la dernière mise à jour */
	@Column(name = "USER_MAJ")
	private String userMaj;

	/** montantHT : double */
	@Transient
	private double montantHt;

	/** montantTva : double */
	@Transient
	private double montantTva;

	/** montantTTC : double */
	@Transient
	private double montantTtc;

	/**
	 * Constructor
	 * 
	 */
	public BonCommande() {
		lignes = new ArrayList<LigneCommande>();
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
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * Setter
	 * 
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * Getter
	 * 
	 * @return the societe
	 */
	public Societe getSociete() {
		return societe;
	}

	/**
	 * Setter
	 * 
	 * @param societe the societe to set
	 */
	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	/**
	 * Getter
	 * 
	 * @return the lignes
	 */
	public List<LigneCommande> getLignes() {
		return lignes;
	}

	/**
	 * Setter
	 * 
	 * @param lignes the lignes to set
	 */
	public void setLignes(List<LigneCommande> lignes) {
		this.lignes = lignes;
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
	 * @return the montantHt
	 */
	public double getMontantHt() {
		return montantHt;
	}

	/**
	 * Setter
	 * 
	 * @param montantHt the montantHt to set
	 */
	public void setMontantHt(double montantHt) {
		this.montantHt = montantHt;
	}

	/**
	 * Getter
	 * 
	 * @return the montantTva
	 */
	public double getMontantTva() {
		return montantTva;
	}

	/**
	 * Setter
	 * 
	 * @param montantTva the montantTva to set
	 */
	public void setMontantTva(double montantTva) {
		this.montantTva = montantTva;
	}

	/**
	 * Getter
	 * 
	 * @return the montantTtc
	 */
	public double getMontantTtc() {
		return montantTtc;
	}

	/**
	 * Setter
	 * 
	 * @param montantTtc the montantTtc to set
	 */
	public void setMontantTtc(double montantTtc) {
		this.montantTtc = montantTtc;
	}
}
