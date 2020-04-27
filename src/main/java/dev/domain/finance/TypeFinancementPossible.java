package dev.domain.finance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	/** Nombre d'unités pour ce type de financement */
	@Column(name = "NBR_UNITE")
	private Integer nbrUnites;
	
	/** Montant unite HT du financement */
	@Column(name = "MONTANT_UNITE_HT")
	private Float montantUniteHT;

	@Enumerated(EnumType.STRING)
	@Column(name = "UNITE")
	private UniteMontantTypeFinancement uniteMontant;

	/** Taux de TVA appliqué au montant du  financement */
	@Column(name = "TAUX_TVA")
	private Float tauxTVA;
	
	@OneToMany(mappedBy = "typeFinancementPossible", fetch = FetchType.LAZY)
	private List<TypeFinancementChoisi> financementsChoisis = new ArrayList<>();

	/**
	 * 
	 */
	public TypeFinancementPossible() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the nbrUnites
	 */
	public Integer getNbrUnites() {
		return nbrUnites;
	}

	/** Setter
	 * @param nbrUnites the nbrUnites to set
	 */
	public void setNbrUnites(Integer nbrUnites) {
		this.nbrUnites = nbrUnites;
	}

	/** Getter
	 * @return the montantUniteHT
	 */
	public Float getMontantUniteHT() {
		return montantUniteHT;
	}

	/** Setter
	 * @param montantUniteHT the montantUniteHT to set
	 */
	public void setMontantUniteHT(Float montantUniteHT) {
		this.montantUniteHT = montantUniteHT;
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
	 * @return the financementsChoisis
	 */
	public List<TypeFinancementChoisi> getFinancementsChoisis() {
		return financementsChoisis;
	}

	/** Setter
	 * @param financementsChoisis the financementsChoisis to set
	 */
	public void setFinancementsChoisis(List<TypeFinancementChoisi> financementsChoisis) {
		this.financementsChoisis = financementsChoisis;
	}




}
