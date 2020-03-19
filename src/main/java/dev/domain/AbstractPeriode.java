package dev.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.dgn.planification.sessions.StatutValidation;

/**
 * Représente une période abstraite
 * 
 * @author DIGINAMIC
 *
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractPeriode implements Evenement {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	/** nom : String */
	@Column(name = "NOM", length = 50)
	protected String nom;

	/** dateDebut : LocalDate */
	@Column(name = "DATE_DEB")
	protected LocalDate dateDebut;

	/** dateFin : LocalDate */
	@Column(name = "DATE_FIN")
	protected LocalDate dateFin;

	/**
	 * Constructeur
	 * 
	 */
	public AbstractPeriode() {
	}

	/**
	 * Constructeur
	 * 
	 * @param date date de fermeture
	 */
	public AbstractPeriode(LocalDate date) {
		this.dateDebut = date.minus(0, ChronoUnit.SECONDS);
		this.dateFin = date.minus(0, ChronoUnit.SECONDS);
	}

	/**
	 * Constructeur
	 * 
	 * @param dateDebut date de début
	 * @param dateFin date de fin
	 */
	public AbstractPeriode(LocalDate dateDebut, LocalDate dateFin) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AbstractPeriode other = (AbstractPeriode) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		}
		else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/**
	 * Une période abstraite genre congé ou indisponibilité formateur est considérée comme validée
	 * par défaut.
	 * 
	 * @return VALIDE
	 */
	@Override
	public StatutValidation getStatutValidation() {
		return StatutValidation.VALIDE;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	@Override
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
	 * @return the nom
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractPeriode [nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
}
