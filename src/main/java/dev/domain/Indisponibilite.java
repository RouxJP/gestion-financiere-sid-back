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
@Table(name = "INDISPONIBILITE")
@Cacheable(value = true)
public class Indisponibilite extends AbstractPeriode {

	/** utilisateur : Utilisateur */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UTILISATEUR")
	private Utilisateur utilisateur;

	/**
	 * Constructeur
	 */
	public Indisponibilite() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param dateDebut date de début
	 * @param dateFin date de fin
	 */
	public Indisponibilite(LocalDate dateDebut, LocalDate dateFin) {
		super(dateDebut, dateFin);
	}

	/**
	 * Getter
	 * 
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * Setter
	 * 
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String getRessource() {
		return utilisateur.getNom();
	}

	@Override
	public TypeEvenement getType() {
		return TypeEvenement.INDISPO_FORMATEUR;
	}

	@Override
	public Centre getCentre() {
		return new TousCentres();
	}
}
