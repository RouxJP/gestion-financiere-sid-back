package dev.domain.notation;

import java.time.LocalDate;
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

/**
 * Représente un bilan mensuel stagiaire
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "BILAN_STAGIAIRE")
public class BilanStagiaire implements Comparable<BilanStagiaire> {

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

	/** moyennes : List de Moyenne */
	@OneToMany(mappedBy = "bilan")
	private List<Moyenne> moyennes = new ArrayList<>();

	/** bulletin : Bulletin */
	@ManyToOne
	@JoinColumn(name = "ID_BULLETIN")
	private Bulletin bulletin;

	/** publication : Boolean */
	@Column(name = "PUBLICATION")
	private Boolean publication;

	/** userMaj : String */
	@Column(name = "USER_MAJ")
	private String userMaj;

	/** dateMaj : LocalDateTime */
	@Column(name = "DATE_MAJ")
	private LocalDateTime dateMaj;

	@Override
	public int compareTo(BilanStagiaire o) {
		if (this.getNumero() > o.getNumero()) {
			return 1;
		}
		else if (this.getNumero() < o.getNumero()) {
			return -1;
		}
		return 0;
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
	 * @return the moyennes
	 */
	public List<Moyenne> getMoyennes() {
		return moyennes;
	}

	/**
	 * Setter
	 * 
	 * @param moyennes the moyennes to set
	 */
	public void setMoyennes(List<Moyenne> moyennes) {
		this.moyennes = moyennes;
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
	 * @return the publication
	 */
	public Boolean getPublication() {
		return publication;
	}

	/**
	 * Setter
	 * 
	 * @param publication the publication to set
	 */
	public void setPublication(Boolean publication) {
		this.publication = publication;
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

}
