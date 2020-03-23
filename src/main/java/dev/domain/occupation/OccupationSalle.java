package dev.domain.occupation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.domain.Centre;
import dev.domain.Evenement;
import dev.domain.Salle;
import dev.domain.StatutValidation;
import dev.domain.TypeEvenement;

/**
 * Correspond à une période où une salle est occupée ou non occupée.
 * 
 * @author DIGINAMIC
 *
 */
public class OccupationSalle implements Evenement {

	/** salle : Salle */
	private Salle salle;
	/** besoinSalle : boolean */
	private boolean besoinSalle;
	/** dateDebut : LocalDate */
	private LocalDate dateDebut;
	/** dateFin : LocalDate */
	private LocalDate dateFin;
	/** position : int */
	private int position;
	/** cours : List */
	private List<Long> cours = new ArrayList<>();

	/**
	 * Constructor
	 * 
	 * @param dateDebut date de début
	 * @param dateFin   date de fin
	 */
	public OccupationSalle(LocalDate dateDebut, LocalDate dateFin) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.besoinSalle = false;
	}

	/**
	 * Constructor
	 * 
	 * @param dateDebut date de début
	 * @param dateFin   date de fin
	 * @param salle     salle
	 */
	public OccupationSalle(LocalDate dateDebut, LocalDate dateFin, Salle salle) {
		this(dateDebut, dateFin);
		this.salle = salle;
		this.besoinSalle = true;
	}

	@Override
	public String toString() {
		return "Occupation [salle=" + salle + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", cours=" + cours
				+ "]";
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

	/**
	 * Getter
	 * 
	 * @return the besoinSalle
	 */
	public boolean isBesoinSalle() {
		return besoinSalle;
	}

	/**
	 * Setter
	 * 
	 * @param besoinSalle the besoinSalle to set
	 */
	public void setBesoinSalle(boolean besoinSalle) {
		this.besoinSalle = besoinSalle;
	}

	/**
	 * Getter
	 * 
	 * @return the dateDebut
	 */
	@Override
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Getter
	 * 
	 * @return the dateFin
	 */
	@Override
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * Setter
	 * 
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public String getNom() {
		return null;
	}

	@Override
	public String getRessource() {
		return null;
	}

	@Override
	public Centre getCentre() {
		return null;
	}

	@Override
	public TypeEvenement getType() {
		return null;
	}

	@Override
	public StatutValidation getStatutValidation() {
		return null;
	}

	/**
	 * Getter
	 * 
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Setter
	 * 
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * Getter
	 * 
	 * @return the cours
	 */
	public List<Long> getCours() {
		return cours;
	}

	/**
	 * Setter
	 * 
	 * @param cours the cours to set
	 */
	public void setCours(List<Long> cours) {
		this.cours = cours;
	}
}
