package dev.domain.finance;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.domain.SessionStagiaire;

/**
 * Représente un type de financement choisi d'une session de formation :
 * avec son libellé 			: libelle ( Pôle emploi, OPCA, Perso, Entreprise, Autre...)
 * 		sa durée de validité  	: date_deb, date_fin 
 *      son mode de calcul    	: unites
 *      ses valeurs de calculs	: nbr_heures, montant_ht, taux_tva
 *      
 * Les unités sont des montants :
 *       - horaires par groupe
 *       - horaires par stagiaire
 *       - forfaitaires par stagiaire
 *       -...
 * On peut en déduire le calcul d'un type de financement par session-stagiaire
 * 
 * Un type de financement choisi a un contenu identique au type de financement 
 * possible à partir duquel on la créé
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "TYPE_FINANCEMENT_CHOISI")
@Cacheable
public class TypeFinancementChoisi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** Pôle emploi, OPCA, Perso, Entreprise, Autre */
	@Column(name = "libelle")
	private String libelle;  
	
	/** Date de début d'application du type de financement */
	@Column(name = "DATE_DEB")
	private LocalDate dateDebut;

	/** Date de fin d'application du type de financement */
	@Column(name = "DATE_FIN")
	private LocalDate dateFin;
	
	/** Nombre d'heures financé pour ce type de financement */
	@Column(name = "NBR_HEURE")
	private int nbrHeure;
	
	/** Montant HT du financement */
	@Column(name = "MONTANT_HT")
	private Float montantHT;

	@Enumerated(EnumType.STRING)
	@Column(name = "UNITE")
	private UniteMontantTypeFinancement uniteMontant;

	/** Taux de TVA appliqué au montant du  financement */
	@Column(name = "TAUX_TVA")
	private Float tauxTVA;

	/** Type de financement possible auquel il a été relié à sa création */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TYPE_FIN_POSSIBLE")
	private TypeFinancementPossible typeFinancementPossible;
	
	/** Session/stagiaire */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns( {
        @JoinColumn(name = "ID_SESSION",  	referencedColumnName = "ID_SES", 	insertable=false, updatable=false),
        @JoinColumn(name = "ID_STAGIAIRE", 	referencedColumnName = "ID_STAG", 	insertable=false, updatable=false)
    })	
	private SessionStagiaire sessionStagiaire;

	/**
	 * @param id
	 * @param libelle
	 * @param dateDebut
	 * @param dateFin
	 * @param nbrHeure
	 * @param montantHT
	 * @param uniteMontant
	 * @param tauxTVA
	 * @param typeFinancementPossible
	 * @param sessionStagiaire
	 */
	public TypeFinancementChoisi(Long id, String libelle, LocalDate dateDebut, LocalDate dateFin, int nbrHeure,
			Float montantHT, UniteMontantTypeFinancement uniteMontant, Float tauxTVA,
			TypeFinancementPossible typeFinancementPossible, SessionStagiaire sessionStagiaire) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbrHeure = nbrHeure;
		this.montantHT = montantHT;
		this.uniteMontant = uniteMontant;
		this.tauxTVA = tauxTVA;
		this.typeFinancementPossible = typeFinancementPossible;
		this.sessionStagiaire = sessionStagiaire;
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
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/** Getter
	 * @return the nbrHeure
	 */
	public int getNbrHeure() {
		return nbrHeure;
	}

	/** Setter
	 * @param nbrHeure the nbrHeure to set
	 */
	public void setNbrHeure(int nbrHeure) {
		this.nbrHeure = nbrHeure;
	}

	/** Getter
	 * @return the montantHT
	 */
	public Float getMontantHT() {
		return montantHT;
	}

	/** Setter
	 * @param montantHT the montantHT to set
	 */
	public void setMontantHT(Float montantHT) {
		this.montantHT = montantHT;
	}

	/** Getter
	 * @return the uniteMontant
	 */
	public UniteMontantTypeFinancement getUniteMontant() {
		return uniteMontant;
	}

	/** Setter
	 * @param uniteMontant the uniteMontant to set
	 */
	public void setUniteMontant(UniteMontantTypeFinancement uniteMontant) {
		this.uniteMontant = uniteMontant;
	}

	/** Getter
	 * @return the tauxTVA
	 */
	public Float getTauxTVA() {
		return tauxTVA;
	}

	/** Setter
	 * @param tauxTVA the tauxTVA to set
	 */
	public void setTauxTVA(Float tauxTVA) {
		this.tauxTVA = tauxTVA;
	}

	/** Getter
	 * @return the typeFinancementPossible
	 */
	public TypeFinancementPossible getTypeFinancementPossible() {
		return typeFinancementPossible;
	}

	/** Setter
	 * @param typeFinancementPossible the typeFinancementPossible to set
	 */
	public void setTypeFinancementPossible(TypeFinancementPossible typeFinancementPossible) {
		this.typeFinancementPossible = typeFinancementPossible;
	}

	/** Getter
	 * @return the sessionStagiaire
	 */
	public SessionStagiaire getSessionStagiaire() {
		return sessionStagiaire;
	}

	/** Setter
	 * @param sessionStagiaire the sessionStagiaire to set
	 */
	public void setSessionStagiaire(SessionStagiaire sessionStagiaire) {
		this.sessionStagiaire = sessionStagiaire;
	}
	

}
