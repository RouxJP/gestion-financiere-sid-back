package dev.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Représente une salle de formation (informatique ou communication) au sein d'un centre.
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "SALLE")
@Cacheable(value = true)
public class Salle implements Ressource {

	/** identifiant */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/** Nom de la salle */
	@Column(name = "NOM")
	private String nom;

	/** Type (informatique ou communication) */
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private TypeSalle type;

	/** capacite d'accueil en nombre de stagiaires */
	@Column(name = "capacite")
	private Integer capacite;

	/** centre où se trouve la salle */
	@ManyToOne
	@JoinColumn(name = "ID_CENT")
	private Centre centre;

	/** sessions qui occupent cette salle */
	@OneToMany(mappedBy = "salle")
	private List<Session> sessions;

	/** dateFinValidite : LocalDate */
	@Column(name = "DATE_FIN_VALIDITE")
	private LocalDate dateFinValidite;

	/** indisponibilites : List de IndisponibiliteSalle */
	@OneToMany(mappedBy = "salle")
	private List<IndisponibiliteSalle> indisponibilites = new ArrayList<>();

	/**
	 * Constructeur
	 */
	public Salle() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param id identifiant de la salle
	 * @param nom nom de la salle
	 */
	public Salle(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	/**
	 * Constructeur
	 * 
	 * @param nom nom de la salle
	 * @param centre centre
	 */
	public Salle(String nom, Centre centre) {
		super();
		this.nom = nom;
		this.centre = centre;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Salle)) {
			return false;
		}
		Salle other = (Salle) obj;
		return new EqualsBuilder().append(nom, other.getNom()).append(centre, other.getCentre()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nom).append(centre).toHashCode();
	}

	@Override
	public TypeRessource getTypeRessource() {
		return TypeRessource.SALLE;
	}

	@Override
	public String getAttribute() {
		return "salle.nom";
	}

	@Override
	public String getValue() {
		return this.nom;
	}

	@Override
	public String toString() {
		return this.nom;
	}

	/**
	 * Getter for nom
	 * 
	 * @return the nom
	 */
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
	 * Getter for centre
	 * 
	 * @return the centre
	 */
	public Centre getCentre() {
		return centre;
	}

	/**
	 * Setter
	 * 
	 * @param centre the centre to set
	 */
	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	/**
	 * Getter for sessions
	 * 
	 * @return the sessions
	 */
	public List<Session> getSessions() {
		return sessions;
	}

	/**
	 * Setter
	 * 
	 * @param sessions the sessions to set
	 */
	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	/**
	 * Getter for id
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
	 * Getter for type
	 * 
	 * @return the type
	 */
	public TypeSalle getType() {
		return type;
	}

	/**
	 * Setter
	 * 
	 * @param type the type to set
	 */
	public void setType(TypeSalle type) {
		this.type = type;
	}

	/**
	 * Getter for capacite
	 * 
	 * @return the capacite
	 */
	public Integer getCapacite() {
		return capacite;
	}

	/**
	 * Setter
	 * 
	 * @param capacite the capacite to set
	 */
	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	/**
	 * Getter
	 * 
	 * @return the indisponibilites
	 */
	@Override
	public List<IndisponibiliteSalle> getIndisponibilites() {
		return indisponibilites;
	}

	/**
	 * Setter
	 * 
	 * @param indisponibilites the indisponibilites to set
	 */
	public void setIndisponibilites(List<IndisponibiliteSalle> indisponibilites) {
		this.indisponibilites = indisponibilites;
	}

	/**
	 * Getter
	 * 
	 * @return the dateFinValidite
	 */
	public LocalDate getDateFinValidite() {
		return dateFinValidite;
	}

	/**
	 * Setter
	 * 
	 * @param dateFinValidite the dateFinValidite to set
	 */
	public void setDateFinValidite(LocalDate dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}
}
