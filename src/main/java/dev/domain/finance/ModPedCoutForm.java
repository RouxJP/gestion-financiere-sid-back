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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.domain.ModalitePedagogique;
import dev.domain.Utilisateur;

/**
 * Représente cout formatteur pour une modalitée pédagogique
 * 
 * @author JP ROUX
 *
 */
@Entity
@Table(name = "COUT_FORMATTEUR_MODP")
@Cacheable(value = true)
public class ModPedCoutForm {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	/** libelle : String */
	@Column(name = "LIBELLE")
	private String libelle;

	/** Cout journalier HT du formatteur */
	@Column(name="COUT_JOUR_HT")
	private float coutJourHT_Formatteur;
	
	/** Droit d'autheur HT du formatteur */
	@Column(name="DROIT_AUTHEUR_HT")
	private float droitAutheurHT_Formatteur;
	
	/** Date de début de validité des couts */
	@Column(name="DAT_DEB_VAL")
	private LocalDate dateDebutValidite;
	
	/** Date de fin de validité des couts */
	@Column(name="DAT_FIN_VAL")
	private LocalDate dateFinValidite;
	
	/** Clef étrangère sur Formatteur */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UTILISATEUR")
	private Utilisateur utilisateur;

	/** Clef étrangère sur Modalités Pédagogiques */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_MOD_PED")
	private ModalitePedagogique modalitePedagogique;
	
	
	/**
	 * Constructor
	 * 
	 */
	public ModPedCoutForm() {
		super();
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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}


	/** Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	/** Getter
	 * @return the coutJourHT_Formatteur
	 */
	public float getCoutJourHT_Formatteur() {
		return coutJourHT_Formatteur;
	}


	/** Setter
	 * @param coutJourHT_Formatteur the coutJourHT_Formatteur to set
	 */
	public void setCoutJourHT_Formatteur(float coutJourHT_Formatteur) {
		this.coutJourHT_Formatteur = coutJourHT_Formatteur;
	}


	/** Getter
	 * @return the droitAutheurHT_Formatteur
	 */
	public float getDroitAutheurHT_Formatteur() {
		return droitAutheurHT_Formatteur;
	}


	/** Setter
	 * @param droitAutheurHT_Formatteur the droitAutheurHT_Formatteur to set
	 */
	public void setDroitAutheurHT_Formatteur(float droitAutheurHT_Formatteur) {
		this.droitAutheurHT_Formatteur = droitAutheurHT_Formatteur;
	}


	/** Getter
	 * @return the dateDebutValidite
	 */
	public LocalDate getDateDebutValidite() {
		return dateDebutValidite;
	}


	/** Setter
	 * @param dateDebutValidite the dateDebutValidite to set
	 */
	public void setDateDebutValidite(LocalDate dateDebutValidite) {
		this.dateDebutValidite = dateDebutValidite;
	}


	/** Getter
	 * @return the dateFinValidite
	 */
	public LocalDate getDateFinValidite() {
		return dateFinValidite;
	}


	/** Setter
	 * @param dateFinValidite the dateFinValidite to set
	 */
	public void setDateFinValidite(LocalDate dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}


	/** Getter
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	/** Setter
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	/** Getter
	 * @return the modalitePedagogique
	 */
	public ModalitePedagogique getModalitePedagogique() {
		return modalitePedagogique;
	}


	/** Setter
	 * @param modalitePedagogique the modalitePedagogique to set
	 */
	public void setModalitePedagogique(ModalitePedagogique modalitePedagogique) {
		this.modalitePedagogique = modalitePedagogique;
	}


}
