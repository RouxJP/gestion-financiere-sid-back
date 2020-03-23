package dev.domain;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Représente une période non travaillée, et donc sans formation, pour
 * l'ensemble de la société. Une période fermée a une date de début, une date de
 * fin et un libellé (ex: 1er mai)
 * 
 * @author DIGINAMIC
 */
@Entity
@Table(name = "PERIODE_FERME")
@Cacheable(value = true)
public class PeriodeFermee extends AbstractPeriode {

	/** type : représente le type de la période. Exemple: fermeture officielle */
	@Column(name = "TYPE", length = 50, nullable = true)
	@Enumerated(EnumType.STRING)
	private TypeEvenement type;

	/**
	 * Constructeur
	 */
	public PeriodeFermee() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param date date de fermeture
	 */
	public PeriodeFermee(LocalDate date) {
		super(date);
	}

	/**
	 * Constructeur
	 * 
	 * @param dateDebut date de début
	 * @param dateFin   date de fin
	 */
	public PeriodeFermee(LocalDate dateDebut, LocalDate dateFin) {
		super(dateDebut, dateFin);
	}

	@Override
	public String getRessource() {
		return "";
	}

	@Override
	public Centre getCentre() {
		return new TousCentres();
	}

	/**
	 * Getter
	 * 
	 * @return the type
	 */
	@Override
	public TypeEvenement getType() {
		return type;
	}

	/**
	 * Setter
	 * 
	 * @param type the type to set
	 */
	public void setType(TypeEvenement type) {
		this.type = type;
	}
}
