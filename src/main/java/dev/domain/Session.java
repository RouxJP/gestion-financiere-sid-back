package dev.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.time.DateUtils;
import org.dgn.planification.sessions.StatutPreparation;
import org.dgn.planification.sessions.StatutValidation;

import dev.domain.notation.BilanSession;

/**
 * Représente une session (une formation planifiée à une date donnée avec une
 * liste de stagiaires)
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "SESSION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("VERSION")
public class Session implements Evenement, Cloneable {

	/** identifiant */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/** centre : Centre */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CENTRE")
	private Centre centre;

	/** societe : Societe */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SOCIETE")
	private Societe societe;

	/** Nom de la session */
	@Column(name = "NOM")
	private String nom;

	/** Date de début */
	@Column(name = "DATE_DEB")
	private LocalDate dateDebut;

	/** Date de fin */
	@Column(name = "DATE_FIN")
	private LocalDate dateFin;

	/** Formation */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FOR")
	private Formation formation;

	/** Liste des cours */
	@OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
	private List<CoursPlanifie> cours = new ArrayList<>();

	/** Liste des dates fermées spécifique pour cette session */
	@OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
	private List<PeriodeFermeeSession> fermes = new ArrayList<>();

	/** bilans : List de BilanSession */
	@OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
	private List<BilanSession> bilans = new ArrayList<>();

	/** Salle d'informatique par défaut dans laquelle aura lieu la formation */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SAL")
	private Salle salle;

	/** todoListe : TodoListePlanifiee */
	@Transient
	private TodoListePlanifiee todoListe;

	/** dateMaj : LocalDateTime */
	@Column(name = "DATE_MAJ")
	private LocalDateTime dateMaj;

	/** userMaj : String */
	@Column(name = "USER_MAJ")
	private String userMaj;

	/** previous : Session */
	@Column(name = "ID_PREVIOUS")
	private Long idPrevious;

	/** parent : Session */
	@Column(name = "ID_PARENT")
	private Long idParent;

	/** next : Session */
	@Column(name = "ID_NEXT")
	private Long idNext;

	/** statutValidation : StatutValidation */
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUT_VALIDATION")
	private StatutValidation statutValidation;

	/** statutPreparation : StatutPreparation */
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUT_PREPARATION")
	private StatutPreparation statutPreparation;

	/** stagiaires : List de Utilisateur */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SESSION_STAGIAIRE", joinColumns = @JoinColumn(name = "ID_SES", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_STAG", referencedColumnName = "ID"))
	private Set<Utilisateur> stagiaires = new HashSet<>();

	/** planificateurs : List de Utilisateur */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SESSION_PLANIFICATEUR", joinColumns = @JoinColumn(name = "ID_SES", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_USER", referencedColumnName = "ID"))
	private Set<Utilisateur> planificateurs = new HashSet<>();

	/** staffé sans : boolean */
	@Column(name = "SANS_CONFLIT")
	private boolean staffeSansConflit;

	/** nbBilans : Integer */
	@Column(name = "NB_BILANS")
	private Integer nbBilans = 3;

	/** synthese : String */
	@Column(name = "SYNTHESE")
	private String synthese;

	/** nbStagiaires : Integer */
	@Transient
	private Integer nbStagiaires;

	/** calculMoyenneParBlocs : boolean */
	@Transient
	private String calculMoyenneParBlocs;

	/**
	 * Constructeur
	 */
	public Session() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param id identifiant
	 */
	public Session(Long id) {
		this.id = id;
	}

	/**
	 * Constructeur
	 * 
	 * @param id               identifiant
	 * @param nom              nom
	 * @param dateDebut        date de début
	 * @param dateFin          date de fin
	 * @param idFormation      id de la formation
	 * @param nomCertification nom de la certification
	 */
	public Session(Long id, String nom, LocalDate dateDebut, LocalDate dateFin, Long idFormation,
			String nomCertification) {
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.formation = new Formation(idFormation, nomCertification);
	}

	/**
	 * Constructeur
	 * 
	 * @param id        identifiant
	 * @param nom       nom
	 * @param formation formation
	 */
	public Session(Long id, String nom, Formation formation) {
		this.id = id;
		this.nom = nom;
		this.formation = formation;
	}

	/**
	 * Constructeur
	 * 
	 * @param formation formation associée
	 * @param dateDebut date de début
	 * @param feries    liste des jours feriés
	 */
	public Session(Formation formation, LocalDate dateDebut, List<AbstractPeriode> feries) {
		this.formation = formation;
		this.dateDebut = dateDebut;

		this.dateFin = DateUtils.calculeDateFin(dateDebut, feries, formation.getDuree());
	}

	/**
	 * Calcule la durée d'une session en nb de jours
	 * 
	 * @return int
	 */
	public int calculerDuree() {
		return cours.stream().mapToInt(c -> c.getDuree()).sum();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nom).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Session)) {
			return false;
		}
		Session other = (Session) obj;
		return new EqualsBuilder().append(this.nom, other.getNom()).isEquals();
	}

	/**
	 * Retourne les cours planifiés correspondant au cours passé en paramètre.
	 * Attention, on peut en effet avoir plusieurs cours planifiés pour un même
	 * cours.<br>
	 * Exemple: le projet de fin de formation qui est coupé en 2 avec un formateur
	 * en 1ère semaine et un autre formateur en 2ème semaine.
	 * 
	 * @param cc cours
	 * @return {@link CoursPlanifie}
	 */
	public List<CoursPlanifie> getCoursPlanifie(Cours cc) {
		return cours.stream().filter(c -> c.getCours().equals(cc)).collect(Collectors.toList());
	}

	/**
	 * Retourne le cours planifié dont l'identifiant est passé en paraètre
	 * 
	 * @param id identifiant recherché
	 * @return {@link CoursPlanifie}
	 */
	public CoursPlanifie getCoursPlanifie(Long id) {
		for (CoursPlanifie courant : cours) {
			if (courant.getId() != null && courant.getId().equals(id)) {
				return courant;
			}
		}
		return null;
	}

	/**
	 * Retourne si oui ou non la personne dont l'email est passé en paramètre est
	 * planificateur sur la session.
	 * 
	 * @param email email du planificateur
	 * @return boolean
	 */
	public boolean hasPlanificateur(String email) {

		return StringUtils.isNotEmpty(email) && CollectionUtils.isNotEmpty(planificateurs)
				&& planificateurs.stream().filter(p -> p.getEmail().equals(email)).findAny().isPresent();
	}

	/**
	 * Retourne si oui ou non la personne dont l'email est passé en paramètre est
	 * formateur sur la session.
	 * 
	 * @param email email du planificateur
	 * @return boolean
	 */
	public boolean hasFormateur(String email) {
		return StringUtils.isNotEmpty(email) && CollectionUtils.isNotEmpty(cours)
				&& cours.stream().filter(c -> c.getFormateur() != null && c.getFormateur().getEmail().equals(email))
						.findAny().isPresent();
	}

	/**
	 * Retourne si oui ou non la session est affectée à la société passée en
	 * paramètre (i.e. la session est commandée par la société ou un des stagiaires
	 * est associée à la société)
	 * 
	 * @param societe société
	 * @return boolean
	 */
	public boolean hasSociete(Societe societe) {

		return (this.societe != null && societe != null && (this.societe.equals(societe))) || (societe != null
				&& stagiaires.stream().filter(s -> s.getSociete().equals(societe)).findAny().isPresent());
	}

	@Override
	public TypeEvenement getType() {
		return TypeEvenement.SESSION;
	}

	@Override
	public String getRessource() {
		if (centre != null) {
			return centre.getNom();
		}
		return "";
	}

	/**
	 * Getter for dateDebut
	 * 
	 * @return the dateDebut
	 */
	@Override
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * Getter for dateFin
	 * 
	 * @return the dateFin
	 */
	@Override
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * Getter for formation
	 * 
	 * @return the formation
	 */
	public Formation getFormation() {
		return formation;
	}

	/**
	 * Getter for id
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
	 * Setter
	 * 
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Setter
	 * 
	 * @param formation the formation to set
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	/**
	 * Getter for salle
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
	 * Getter for cours
	 * 
	 * @return the cours
	 */
	public List<CoursPlanifie> getCours() {
		return cours;
	}

	/**
	 * Setter
	 * 
	 * @param cours the cours to set
	 */
	public void setCours(List<CoursPlanifie> cours) {
		this.cours = cours;
	}

	/**
	 * Getter for nom
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
	 * @return the todoListe
	 */
	public TodoListePlanifiee getTodoListe() {
		return todoListe;
	}

	/**
	 * Setter
	 * 
	 * @param todoListe the todoListe to set
	 */
	public void setTodoListe(TodoListePlanifiee todoListe) {
		this.todoListe = todoListe;
	}

	/**
	 * Getter
	 * 
	 * @return the fermes
	 */
	public List<PeriodeFermeeSession> getFermes() {
		return fermes;
	}

	/**
	 * Setter
	 * 
	 * @param fermes the fermes to set
	 */
	public void setFermes(List<PeriodeFermeeSession> fermes) {
		this.fermes = fermes;
	}

	/**
	 * Getter
	 * 
	 * @return the centre
	 */
	@Override
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
	 * Getter
	 * 
	 * @return the societe
	 */
	public Societe getSociete() {
		return societe;
	}

	/**
	 * Setter
	 * 
	 * @param societe the societe to set
	 */
	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	/**
	 * Getter
	 * 
	 * @return the staffeSansConflit
	 */
	public boolean isStaffeSansConflit() {
		return staffeSansConflit;
	}

	/**
	 * Setter
	 * 
	 * @param staffeSansConflit the staffeSansConflit to set
	 */
	public void setStaffeSansConflit(boolean staffeSansConflit) {
		this.staffeSansConflit = staffeSansConflit;
	}

	/**
	 * Getter
	 * 
	 * @return the statutValidation
	 */
	@Override
	public StatutValidation getStatutValidation() {
		return statutValidation;
	}

	/**
	 * Setter
	 * 
	 * @param statutValidation the statutValidation to set
	 */
	public void setStatutValidation(StatutValidation statutValidation) {
		this.statutValidation = statutValidation;
	}

	/**
	 * Recherche d'un cours par date de début
	 * 
	 * @param dateDebut date de début
	 * @return {@link CoursPlanifie}
	 */
	public CoursPlanifie extraireCoursParDateDebut(LocalDate dateDebut) {
		if (CollectionUtils.isEmpty(cours)) {
			return null;
		}
		for (CoursPlanifie cc : cours) {
			if (cc.getDateDebut() != null && cc.getDateDebut().equals(dateDebut)) {
				return cc;
			}
		}
		return null;
	}

	/**
	 * Recherche d'un cours actif à la date passée en paramètre
	 * 
	 * @param date date d'activité du cours
	 * @return {@link CoursPlanifie}
	 */
	public CoursPlanifie extraireCoursParDate(LocalDate date) {
		for (CoursPlanifie cc : cours) {
			if (DateUtils.chevauchement(cc, date)) {
				return cc;
			}
		}
		return null;
	}

	/**
	 * Getter
	 * 
	 * @return the stagiaires
	 */
	public Set<Utilisateur> getStagiaires() {
		return stagiaires;
	}

	/**
	 * Setter
	 * 
	 * @param stagiaires the stagiaires to set
	 */
	public void setStagiaires(Set<Utilisateur> stagiaires) {
		this.stagiaires = stagiaires;
	}

	/**
	 * Getter
	 * 
	 * @return the nbBilans
	 */
	public Integer getNbBilans() {
		return nbBilans;
	}

	/**
	 * Setter
	 * 
	 * @param nbBilans the nbBilans to set
	 */
	public void setNbBilans(Integer nbBilans) {
		this.nbBilans = nbBilans;
	}

	/**
	 * Getter
	 * 
	 * @return the bilans
	 */
	public List<BilanSession> getBilans() {
		return bilans;
	}

	/**
	 * Setter
	 * 
	 * @param bilans the bilans to set
	 */
	public void setBilans(List<BilanSession> bilans) {
		this.bilans = bilans;
	}

	/**
	 * Getter
	 * 
	 * @return the planificateurs
	 */
	public Set<Utilisateur> getPlanificateurs() {
		return planificateurs;
	}

	/**
	 * Setter
	 * 
	 * @param planificateurs the planificateurs to set
	 */
	public void setPlanificateurs(Set<Utilisateur> planificateurs) {
		this.planificateurs = planificateurs;
	}

	/**
	 * Getter
	 * 
	 * @return the statutPreparation
	 */
	public StatutPreparation getStatutPreparation() {
		return statutPreparation;
	}

	/**
	 * Setter
	 * 
	 * @param statutPreparation the statutPreparation to set
	 */
	public void setStatutPreparation(StatutPreparation statutPreparation) {
		this.statutPreparation = statutPreparation;
	}

	/**
	 * Getter
	 * 
	 * @return the nbStagiaires
	 */
	public Integer getNbStagiaires() {
		return nbStagiaires;
	}

	/**
	 * Setter
	 * 
	 * @param nbStagiaires the nbStagiaires to set
	 */
	public void setNbStagiaires(Integer nbStagiaires) {
		this.nbStagiaires = nbStagiaires;
	}

	/**
	 * Getter
	 * 
	 * @return the idParent
	 */
	public Long getIdParent() {
		return idParent;
	}

	/**
	 * Setter
	 * 
	 * @param idParent the idParent to set
	 */
	public void setIdParent(Long idParent) {
		this.idParent = idParent;
	}

	/**
	 * Getter
	 * 
	 * @return the idNext
	 */
	public Long getIdNext() {
		return idNext;
	}

	/**
	 * Setter
	 * 
	 * @param idNext the idNext to set
	 */
	public void setIdNext(Long idNext) {
		this.idNext = idNext;
	}

	/**
	 * Getter
	 * 
	 * @return the idPrevious
	 */
	public Long getIdPrevious() {
		return idPrevious;
	}

	/**
	 * Setter
	 * 
	 * @param idPrevious the idPrevious to set
	 */
	public void setIdPrevious(Long idPrevious) {
		this.idPrevious = idPrevious;
	}

	/**
	 * Getter
	 * 
	 * @return the synthese
	 */
	public String getSynthese() {
		return synthese;
	}

	/**
	 * Setter
	 * 
	 * @param synthese the synthese to set
	 */
	public void setSynthese(String synthese) {
		this.synthese = synthese;
	}

	/**
	 * Getter
	 * 
	 * @return the calculMoyenneParBlocs
	 */
	public String getCalculMoyenneParBlocs() {
		return calculMoyenneParBlocs;
	}

	/**
	 * Setter
	 * 
	 * @param calculMoyenneParBlocs the calculMoyenneParBlocs to set
	 */
	public void setCalculMoyenneParBlocs(String calculMoyenneParBlocs) {
		this.calculMoyenneParBlocs = calculMoyenneParBlocs;
	}

}
