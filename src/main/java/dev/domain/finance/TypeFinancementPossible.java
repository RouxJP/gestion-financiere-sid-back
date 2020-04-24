package dev.domain.finance;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Représente un type de financement possible pour une session/stagiaire
 * Quand on choisi un type de financement pour une session/stagiaire le contenu 
 * de cette table pour ce type de financement est recopié dans la table type_financement_choisi 
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "TYPE_FINANCEMENT_POSSIBLE")
@Cacheable
public class TypeFinancementPossible {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** Pôle emploi, OPCA, Perso, Entreprise, Autre */
	@Column(name = "libelle")
	private String libelle;  

	/** Date de début d'application du type de financement possible */
	@Column(name = "DATE_DEB")
	private LocalDate dateDebut;

	/** Date de fin d'application du type de financement */
	@Column(name = "DATE_FIN")
	private LocalDate dateFin;
	
	@Column(name = "NBR_HEURE")
	private Integer nbrHeures;
	
	/** Montant HT du financement */
	@Column(name = "MONTANT_HT")
	private Float montantHT;

	@Enumerated(EnumType.STRING)
	@Column(name = "UNITE")
	private UniteMontantTypeFinancement uniteMontant;

	/** Taux de TVA appliqué au montant du  financement */
	@Column(name = "TAUX_TVA")
	private Float tauxTVA;

	/**
	 * @param id
	 * @param libelle
	 * @param dateDebut
	 * @param dateFin
	 * @param nbrHeures
	 * @param montantHT
	 * @param uniteMontant
	 * @param tauxTVA
	 */
	public TypeFinancementPossible(Long id, String libelle, LocalDate dateDebut, LocalDate dateFin, Integer nbrHeures,
			Float montantHT, UniteMontantTypeFinancement uniteMontant, Float tauxTVA) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbrHeures = nbrHeures;
		this.montantHT = montantHT;
		this.uniteMontant = uniteMontant;
		this.tauxTVA = tauxTVA;
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
	 * @return the nbrHeures
	 */
	public Integer getNbrHeures() {
		return nbrHeures;
	}

	/** Setter
	 * @param nbrHeures the nbrHeures to set
	 */
	public void setNbrHeures(Integer nbrHeures) {
		this.nbrHeures = nbrHeures;
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

	

}
