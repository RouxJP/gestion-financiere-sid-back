package dev.domain.notation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import dev.domain.Cours;
import dev.domain.CritereNotation;
import dev.domain.Session;
import dev.domain.Utilisateur;

/**
 * Représente un bulletin de note pour un utilisateur donné
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "BULLETIN")
public class Bulletin {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** notes : List de ResultatCours */
	@OneToMany(mappedBy = "bulletin", fetch = FetchType.LAZY)
	private Set<ResultatCours> resultats = new HashSet<>();

	/** bilans : List de Bilan */
	@OneToMany(mappedBy = "bulletin", fetch = FetchType.LAZY)
	private Set<BilanStagiaire> bilans = new HashSet<>();

	/** certification : Certification */
	@OneToMany(mappedBy = "bulletin", fetch = FetchType.LAZY)
	private List<Certification> certifications = new ArrayList<>();

	/** session : Session */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SESSION")
	private Session session;

	/** utilisateur : Utilisateur */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UTILISATEUR")
	private Utilisateur utilisateur;

	/** evalSavoir : String */
	@Column(name = "EVAL_SAVOIR")
	private String evalSavoir;

	/** evalSavoirFaire : String */
	@Column(name = "EVAL_SAVOIR_FAIRE")
	private String evalSavoirFaire;

	/** evalSavoirEtre : String */
	@Column(name = "EVAL_SAVOIR_ETRE")
	private String evalSavoirEtre;

	/** certificatAptitude : String */
	@Column(name = "CERTIFICAT_APTITUDE")
	private String certificatAptitude;

	/** evaluationFinale : String */
	@Column(name = "EVALUATION_FINALE")
	private String evaluationFinale;

	/** userMaj : String */
	@Column(name = "USER_MAJ")
	private String userMaj;

	/** dateMaj : LocalDateTime */
	@Column(name = "DATE_MAJ")
	private LocalDateTime dateMaj;

	/**
	 * Constructor
	 * 
	 */
	public Bulletin() {

	}

	/**
	 * Constructor
	 * 
	 * @param id identifiant
	 * @param utilisateur stagiaire
	 */
	public Bulletin(Long id, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.utilisateur = utilisateur;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Bulletin)) {
			return false;
		}
		Bulletin other = (Bulletin) obj;
		return new EqualsBuilder().append(this.id, other.getId()).isEquals();
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
	 * @return the certifications
	 */
	public List<Certification> getCertifications() {
		return certifications;
	}

	/**
	 * Setter
	 * 
	 * @param certifications the certifications to set
	 */
	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	/**
	 * Getter
	 * 
	 * @return the bilans
	 */
	public Set<BilanStagiaire> getBilans() {
		return bilans;
	}

	/**
	 * Setter
	 * 
	 * @param bilans the bilans to set
	 */
	public void setBilans(Set<BilanStagiaire> bilans) {
		this.bilans = bilans;
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

	/**
	 * Getter
	 * 
	 * @return the resultats
	 */
	public Set<ResultatCours> getResultats() {
		return resultats;
	}

	/**
	 * Setter
	 * 
	 * @param resultats the resultats to set
	 */
	public void setResultats(Set<ResultatCours> resultats) {
		this.resultats = resultats;
	}

	/**
	 * Vérifie si un bulletin a un cours correspondant à celui passé en paramètre
	 * 
	 * @param cours cours à rechercher
	 * @return boolean
	 */
	public boolean exists(Cours cours) {

		for (ResultatCours res : resultats) {
			if (res.getCours().equals(cours)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retourne la note pour un cours donné et un critère de notation donné
	 * 
	 * @param cours cours
	 * @param critere critère de notation
	 * @return Optional
	 */
	public Optional<Note> getNote(Cours cours, CritereNotation critere) {
		ResultatCours resultat = getResultatCours(cours);
		if (resultat != null) {
			return resultat.getNotes().stream().filter(note -> note.getCritereNotation().equals(critere)).findFirst();
		}
		return Optional.empty();
	}

	/**
	 * Retourne toutes les notes pour un cours
	 * 
	 * @param cours cours
	 * @return List
	 */
	public List<Note> getNotes(Cours cours) {
		List<Note> notes = new ArrayList<>();
		resultats.stream().filter(r -> r.getCours().equals(cours)).findFirst()
				.ifPresent(c -> notes.addAll(c.getNotes()));
		return notes;
	}

	/**
	 * Retourne toutes les notes du bulletin
	 * 
	 * @return List
	 */
	public List<Note> getNotes() {
		List<Note> notes = new ArrayList<>();
		resultats.stream().forEach(res -> notes.addAll(res.getNotes()));
		return notes;
	}

	/**
	 * Retourne les résultats associés à un cours donné
	 * 
	 * @param cours cours
	 * @return ResultatCours
	 */
	public ResultatCours getResultatCours(Cours cours) {
		Optional<ResultatCours> optionalResultat = resultats.stream().filter(r -> r.getCours().equals(cours))
				.findFirst();
		if (optionalResultat.isPresent()) {
			return optionalResultat.get();
		}
		return null;
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

	/**
	 * Getter
	 * 
	 * @return the evalSavoir
	 */
	public String getEvalSavoir() {
		return evalSavoir;
	}

	/**
	 * Setter
	 * 
	 * @param evalSavoir the evalSavoir to set
	 */
	public void setEvalSavoir(String evalSavoir) {
		this.evalSavoir = evalSavoir;
	}

	/**
	 * Getter
	 * 
	 * @return the evalSavoirFaire
	 */
	public String getEvalSavoirFaire() {
		return evalSavoirFaire;
	}

	/**
	 * Setter
	 * 
	 * @param evalSavoirFaire the evalSavoirFaire to set
	 */
	public void setEvalSavoirFaire(String evalSavoirFaire) {
		this.evalSavoirFaire = evalSavoirFaire;
	}

	/**
	 * Getter
	 * 
	 * @return the evalSavoirEtre
	 */
	public String getEvalSavoirEtre() {
		return evalSavoirEtre;
	}

	/**
	 * Setter
	 * 
	 * @param evalSavoirEtre the evalSavoirEtre to set
	 */
	public void setEvalSavoirEtre(String evalSavoirEtre) {
		this.evalSavoirEtre = evalSavoirEtre;
	}

	/**
	 * Getter
	 * 
	 * @return the evaluationFinale
	 */
	public String getEvaluationFinale() {
		return evaluationFinale;
	}

	/**
	 * Setter
	 * 
	 * @param evaluationFinale the evaluationFinale to set
	 */
	public void setEvaluationFinale(String evaluationFinale) {
		this.evaluationFinale = evaluationFinale;
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

	/**
	 * Getter
	 * 
	 * @return the certificatAptitude
	 */
	public String getCertificatAptitude() {
		return certificatAptitude;
	}

	/**
	 * Setter
	 * 
	 * @param certificatAptitude the certificatAptitude to set
	 */
	public void setCertificatAptitude(String certificatAptitude) {
		this.certificatAptitude = certificatAptitude;
	}

}
