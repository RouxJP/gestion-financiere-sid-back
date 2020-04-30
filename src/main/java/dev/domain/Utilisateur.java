package dev.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;

import dev.domain.finance.ModPedCoutForm;

/**
 * Représente un utilisateur (administrateur, planificateur, formateur, visiteur
 * ou stagiaire)
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur implements Ressource, Comparable<Utilisateur> {

	/** identifiant */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** société (pour les profils: planificateur, formateur et visiteur) */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SOCIETE")
	private Societe societe;

	/** valideur : Utilisateur */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_VALIDEUR")
	private Utilisateur valideur;

	/** Session associée */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SESSION")
	private Session session;
	
	/** Pour les formateurs, indique si le formateur est certifié */
	@Column(name = "CERTIF_DGN", length = 3)
	private String certifieDgn;

	/**
	 * Type de profil: administrateur, planificateur, formateur, visiteur ou
	 * stagiaire
	 */
	@Column( name = "DEFAULTROLE", nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private TypeRole defaultRole;

	/** Adresse mail */
	@Column(nullable = false, unique = true, length = 30)
	private String email;

	/** Mot de passe */
	@Column(nullable = true, length = 80)
	private String password;

	/** Nom */
	@Column(nullable = false, length = 50)
	private String nom;

	/** Prénom */
	@Column(nullable = false, length = 30)
	private String prenom;

	/** Téléphone */
	@Column(nullable = true, length = 100)
	private String adresse;

	/** Téléphone */
	@Column(nullable = true, length = 15)
	private String telephone;

	/** Indique si le compte de l'utilisateur est activé ou non */
	@Column(nullable = false)
	private boolean enabled;

	/**
	 * checkRGPD : Indique que l'utilisateur a bien accepté les conditions
	 * d'utilisation de ses données
	 */
	@Column(name = "CHECK_RGPD", nullable = false)
	private boolean checkRGPD = true;

	/**
	 * Token unique envoyé par mail à l'utilisateur dans un lien HTTP et qui permet
	 * l'activation de son compte.
	 */
	@Column(name = "TOKEN_INIT")
	private String tokenInit;

	/** Date de création du compte */
	@Column(name = "DATE_CREATION")
	private LocalDateTime dateCreation;

	/** Date de révocation du compte (sur action d'un administrateur) */
	@Column(name = "DATE_DESACTIVATION")
	private LocalDateTime dateDesactivation;

	/**
	 * Date à laquelle le compte a été vérrouillé suite à plus de 3 tentatives de
	 * connexion infructueuses
	 */
	@Column(name = "DATE_LOCKED")
	private LocalDateTime dateLocked;

	/**
	 * Compteur du nombre de tentatives de connexion infructueuses successives. Ce
	 * nb est remis à 0 si l'utilisateur se connecte correctement
	 */
	@Column(name = "NB_ESSAIS")
	private int nbEssais;

	/** Date de dernière mise à jour */
	@Column(name = "DATE_MAJ")
	private LocalDateTime dateMaj;

	/** Auteur de la dernière mise à jour */
	@Column(name = "USER_MAJ")
	private String userMaj;

	/** DEBUT : JP ROUX : calculs finnaciers */
	/** Cout journalier HT du formatteur pour aide à la saisie */
	@Column(name="COUT_JOUR_HT_AIDE_SAISIE")
	private float coutJourHT_Formatteur;
	
	/** Droit d'autheur HT du formatteur pour aide à la saisie */
	@Column(name="DROIT_AUTHEUR_HT_AIDE_SAISIE")
	private float droitAutheurHT_Formatteur;
	/** FIN  : JP ROUX : calculs finnaciers */
	
	/**
	 * Liste des profils de l'utilisateur (exemple: administrateur et formateur)
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ROLE_UTILISATEUR", joinColumns = @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID"))
	private List<RoleCollegue> roles = new ArrayList<>();

	/** Centres sur lesquels l'utilisateur est susceptible d'intervenir */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CENTRE_UTILISATEUR", joinColumns = @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_CENTRE", referencedColumnName = "ID"))
	private Set<Centre> centres = new HashSet<>();

	/** Liste des cours qu'un formateur est capable de donner */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "COURS_PAR_FORMATEUR", joinColumns = @JoinColumn(name = "ID_FRM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COU", referencedColumnName = "ID"))
	private List<CoursRef> cours = new ArrayList<>();

	/** indisponibilites : List de Indisponibilite */
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	private List<Indisponibilite> indisponibilites = new ArrayList<>();

	/** Liste des couts formateurs par modalités pédagogiques JP ROUX*/
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	private List<ModPedCoutForm> modPedCoutForms = new ArrayList<>();

	/**
	 * Uniquement pour un profil stagiaire: un stagiaire peut être rattaché à
	 * plusieurs sessions
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "SESSION_STAGIAIRE", 
				joinColumns = @JoinColumn(name = "ID_STAG", referencedColumnName = "ID"), 
				inverseJoinColumns = @JoinColumn(name = "ID_SES", referencedColumnName = "ID"))
	private List<Session> sessionsStagiaire = new ArrayList<>();

	/**
	 * Uniquement pour un planificateur : Liste des sessions pour lesquelles il est
	 * planificateur
	 */
	@Transient
	private List<Session> sessions = new ArrayList<>();

	/** supprimable : boolean */
	@Transient
	private boolean supprimable;

	/**
	 * Constructor
	 * 
	 */
	public Utilisateur() {

	}

	/**
	 * Constructor
	 * 
	 * @param id identifiant
	 */
	public Utilisateur(Long id) {
		super();
		this.id = id;
	}

	/**
	 * Constructor
	 * 
	 * @param id     identifiant
	 * @param email  email
	 * @param nom    nom
	 * @param prenom prénom
	 */
	public Utilisateur(Long id, String email, String nom, String prenom) {
		super();
		this.id = id;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public TypeRessource getTypeRessource() {
		return TypeRessource.UTILISATEUR;
	}

	@Override
	public String getAttribute() {
		return "formateur.email";
	}

	@Override
	public String getValue() {
		return this.email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Utilisateur)) {
			return false;
		}
		Utilisateur other = (Utilisateur) obj;
		return new EqualsBuilder().append(getEmail(), other.getEmail()).isEquals();
	}

	@Override
	public String toString() {
		return "Utilisateur [email=" + email + "]";
	}

	@Override
	public int compareTo(Utilisateur o) {
		Comparator<Utilisateur> employeeNameComparator = Comparator.comparing(Utilisateur::getNom)
				.thenComparing(Utilisateur::getPrenom);
		return employeeNameComparator.compare(this, o);
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
	 * Getter for password
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter for enabled
	 * 
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Setter
	 * 
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Getter for dateCreation
	 * 
	 * @return the dateCreation
	 */
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	/**
	 * Setter
	 * 
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Getter for dateDesactivation
	 * 
	 * @return the dateDesactivation
	 */
	public LocalDateTime getDateDesactivation() {
		return dateDesactivation;
	}

	/**
	 * Setter
	 * 
	 * @param dateDesactivation the dateDesactivation to set
	 */
	public void setDateDesactivation(LocalDateTime dateDesactivation) {
		this.dateDesactivation = dateDesactivation;
	}

	/**
	 * Getter for nbEssais
	 * 
	 * @return the nbEssais
	 */
	public int getNbEssais() {
		return nbEssais;
	}

	/**
	 * Setter
	 * 
	 * @param nbEssais the nbEssais to set
	 */
	public void setNbEssais(int nbEssais) {
		this.nbEssais = nbEssais;
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
	 * Getter for prenom
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 * 
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter for email
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for telephone
	 * 
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Setter
	 * 
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter for dateLocked
	 * 
	 * @return the dateLocked
	 */
	public LocalDateTime getDateLocked() {
		return dateLocked;
	}

	/**
	 * Setter
	 * 
	 * @param dateLocked the dateLocked to set
	 */
	public void setDateLocked(LocalDateTime dateLocked) {
		this.dateLocked = dateLocked;
	}

	/**
	 * Getter for roles
	 * 
	 * @return the roles
	 */
	public List<RoleCollegue> getRoles() {
		return roles;
	}

	/**
	 * Setter
	 * 
	 * @param roles the roles to set
	 */
	public void setRoles(List<RoleCollegue> roles) {
		this.roles = roles;
	}

	/**
	 * Getter for certifieDgn
	 * 
	 * @return the certifieDgn
	 */
	public String getCertifieDgn() {
		return certifieDgn;
	}

	/**
	 * Setter
	 * 
	 * @param certifieDgn the certifieDgn to set
	 */
	public void setCertifieDgn(String certifieDgn) {
		this.certifieDgn = certifieDgn;
	}

	/**
	 * Getter for cours
	 * 
	 * @return the cours
	 */
	public List<CoursRef> getCours() {
		return cours;
	}

	/**
	 * Setter
	 * 
	 * @param cours the cours to set
	 */
	public void setCours(List<CoursRef> cours) {
		this.cours = cours;
	}

	/**
	 * Getter for dateMaj
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
	 * Getter for userMaj
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
	 * Getter for defaultRole
	 * 
	 * @return the defaultRole
	 */
	public TypeRole getDefaultRole() {
		return defaultRole;
	}

	/**
	 * Setter
	 * 
	 * @param defaultRole the defaultRole to set
	 */
	public void setDefaultRole(TypeRole defaultRole) {
		this.defaultRole = defaultRole;
	}

	/**
	 * Getter for tokenInit
	 * 
	 * @return the tokenInit
	 */
	public String getTokenInit() {
		return tokenInit;
	}

	/**
	 * Setter
	 * 
	 * @param tokenInit the tokenInit to set
	 */
	public void setTokenInit(String tokenInit) {
		this.tokenInit = tokenInit;
	}

	/**
	 * Getter for centres
	 * 
	 * @return the centres
	 */
	public Set<Centre> getCentres() {
		return centres;
	}

	/**
	 * Setter
	 * 
	 * @param centres the centres to set
	 */
	public void setCentres(Set<Centre> centres) {
		this.centres = centres;
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
	 * @return the indisponibilites
	 */
	@Override
	public List<Indisponibilite> getIndisponibilites() {
		return indisponibilites;
	}

	/**
	 * Setter
	 * 
	 * @param indisponibilites the indisponibilites to set
	 */
	public void setIndisponibilites(List<Indisponibilite> indisponibilites) {
		this.indisponibilites = indisponibilites;
	}

	/**
	 * Getter
	 * 
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Setter
	 * 
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Retourne l'identité de l'utilisateur: prénom + nom
	 * 
	 * @return String
	 */
	public String getIdentite() {
		return prenom + " " + nom;
	}

	/**
	 * Getter
	 * 
	 * @return the checkRGPD
	 */
	public boolean isCheckRGPD() {
		return checkRGPD;
	}

	/**
	 * Setter
	 * 
	 * @param checkRGPD the checkRGPD to set
	 */
	public void setCheckRGPD(boolean checkRGPD) {
		this.checkRGPD = checkRGPD;
	}

	/**
	 * Getter
	 * 
	 * @return the valideur
	 */
	public Utilisateur getValideur() {
		return valideur;
	}

	/**
	 * Setter
	 * 
	 * @param valideur the valideur to set
	 */
	public void setValideur(Utilisateur valideur) {
		this.valideur = valideur;
	}

	/**
	 * Getter
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
	 * Getter
	 * 
	 * @return the sessionsStagiaire
	 */
	public List<Session> getSessionsStagiaire() {
		return sessionsStagiaire;
	}

	/**
	 * Setter
	 * 
	 * @param sessionsStagiaire the sessionsStagiaire to set
	 */
	public void setSessionsStagiaire(List<Session> sessionsStagiaire) {
		this.sessionsStagiaire = sessionsStagiaire;
	}

	/**
	 * Getter
	 * 
	 * @return the supprimable
	 */
	public boolean isSupprimable() {
		return supprimable;
	}

	/**
	 * Setter
	 * 
	 * @param supprimable the supprimable to set
	 */
	public void setSupprimable(boolean supprimable) {
		this.supprimable = supprimable;
	}

	/** Getter
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/** Setter
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/** Getter
	 * @return the coutJourHT_Formatteur
	 */
	public float getCoutJourHT_Formatteur() {
		return coutJourHT_Formatteur;
	}

	/** Setter
	 * @param coutJourHT_Formatteur the coutJourHT_Formatteur to set
	 */
	public void setCoutJourHT_Formatteur(float coutJourHT_Formatteur) {
		this.coutJourHT_Formatteur = coutJourHT_Formatteur;
	}

	/** Getter
	 * @return the droitAutheurHT_Formatteur
	 */
	public float getDroitAutheurHT_Formatteur() {
		return droitAutheurHT_Formatteur;
	}

	/** Setter
	 * @param droitAutheurHT_Formatteur the droitAutheurHT_Formatteur to set
	 */
	public void setDroitAutheurHT_Formatteur(float droitAutheurHT_Formatteur) {
		this.droitAutheurHT_Formatteur = droitAutheurHT_Formatteur;
	}

	/** Getter
	 * @return the modPedCoutForms
	 */
	public List<ModPedCoutForm> getModPedCoutForms() {
		return modPedCoutForms;
	}

	/** Setter
	 * @param modPedCoutForms the modPedCoutForms to set
	 */
	public void setModPedCoutForms(List<ModPedCoutForm> modPedCoutForms) {
		this.modPedCoutForms = modPedCoutForms;
	}

	
}