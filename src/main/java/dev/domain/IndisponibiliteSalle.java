package dev.domain;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente une indisponibilité d'un formateur
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "INDISPONIBILITE_SALLE")
@Cacheable(value = true)
public class IndisponibiliteSalle extends AbstractPeriode {

	/** salle : Salle */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SALLE")
	private Salle salle;

	/**
	 * Constructeur
	 */
	public IndisponibiliteSalle() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param dateDebut date de début
	 * @param dateFin date de fin
	 */
	public IndisponibiliteSalle(LocalDate dateDebut, LocalDate dateFin) {
		super(dateDebut, dateFin);
	}

	/**
	 * Getter
	 * 
	 * @return the salle
	 */
	public Salle getSalle() {
		return salle;
	}

	/**
	 * Setter
	 * 
	 * @param salle the salle to set
	 */
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	@Override
	public String getRessource() {
		return salle.getNom();
	}

	@Override
	public Centre getCentre() {
		return salle.getCentre();
	}

	@Override
	public TypeEvenement getType() {
		return TypeEvenement.INDISPO_SALLE;
	}
}
