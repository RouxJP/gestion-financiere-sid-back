package dev.domain

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente des jours fermés spécifiques à la session
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "PERIODE_FERMEE_SESSION")
@Cacheable(value = true)
public class PeriodeFermeeSession extends AbstractPeriode implements Cloneable, PlanningElement {

	/** session : Session */
	@ManyToOne
	@JoinColumn(name = "ID_SESSION")
	private Session session;

	/**
	 * Constructeur
	 */
	public PeriodeFermeeSession() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param date date de fermeture
	 */
	public PeriodeFermeeSession(LocalDate date) {
		super(date);
	}

	/**
	 * Constructeur
	 * 
	 * @param dateDebut date de début
	 * @param dateFin date de fin
	 */
	public PeriodeFermeeSession(LocalDate dateDebut, LocalDate dateFin) {
		super(dateDebut, dateFin);
	}

	/**
	 * Constructeur d'une période à partir d'un évènement
	 * 
	 * @param evenement évènement
	 */
	public PeriodeFermeeSession(Evenement evenement) {
		this.id = evenement.getId();
		this.nom = evenement.getNom();
		this.dateDebut = evenement.getDateDebut();
		this.dateFin = evenement.getDateFin();
	}

	@Override
	public PeriodeFermeeSession clone() {
		PeriodeFermeeSession copy = new PeriodeFermeeSession();
		copy.setDateDebut(dateDebut);
		copy.setDateFin(dateFin);
		copy.setId(id);
		copy.setNom(nom);
		copy.setSession(session);
		return copy;
	}

	@Override
	public TypeEvenement getType() {
		return TypeEvenement.INDISPO_SESSION;
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

	@Override
	public String getRessource() {
		return session.getNom();
	}

	@Override
	public Centre getCentre() {
		return session.getCentre();
	}

	@Override
	public String getLibelle() {
		return "Fermeture du centre";
	}
}
