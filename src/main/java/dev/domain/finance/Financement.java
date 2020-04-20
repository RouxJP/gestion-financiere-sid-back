package dev.domain.finance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.domain.Session;
import dev.domain.Utilisateur;

/**
 * Représente un financement par stagiaire d'une session de formation
 * 	- soit c'est un tarif horaire 
 *  - soit c'est un tarif forfaitaire
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "FINANCEMENT")
public class Financement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_SESSION")
	private Session session;

	@ManyToOne
	@JoinColumn(name = "ID_UTILISATEUR_STAGAIRE")
	private Utilisateur stagiaire;
	
	@ManyToOne
	@JoinColumn(name = "ID_TYPE_FINANCEMENT")
	private TypeFinancement typeFinancement;
	
	@Column(name = "NBR_HEURES")
	private Integer nbrHeures;
	
	@Column(name = "TARIF_HOR_STAGIAIRE")
	private Float tarifHoraireStagiaire;
	
	@Column(name = "TARIF_HOR_GROUPE")
	private Float tarifForfaitaireGroupe;

	/**
	 * @param id
	 * @param session
	 * @param stagiaire
	 * @param typeFinancement
	 * @param nbrHeures
	 * @param tarifHoraireStagiaire
	 * @param tarifForfaitaireGroupe
	 */
	public Financement(Long id, Session session, Utilisateur stagiaire, TypeFinancement typeFinancement,
			Integer nbrHeures, Float tarifHoraireStagiaire, Float tarifForfaitaireGroupe) {
		super();
		this.id = id;
		this.session = session;
		this.stagiaire = stagiaire;
		this.typeFinancement = typeFinancement;
		this.nbrHeures = nbrHeures;
		this.tarifHoraireStagiaire = tarifHoraireStagiaire;
		this.tarifForfaitaireGroupe = tarifForfaitaireGroupe;
	}

	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the stagiaire
	 */
	public Utilisateur getStagiaire() {
		return stagiaire;
	}

	/** Setter
	 * @param stagiaire the stagiaire to set
	 */
	public void setStagiaire(Utilisateur stagiaire) {
		this.stagiaire = stagiaire;
	}

	/** Getter
	 * @return the typeFinancement
	 */
	public TypeFinancement getTypeFinancement() {
		return typeFinancement;
	}

	/** Setter
	 * @param typeFinancement the typeFinancement to set
	 */
	public void setTypeFinancement(TypeFinancement typeFinancement) {
		this.typeFinancement = typeFinancement;
	}

	/** Getter
	 * @return the nbrHeures
	 */
	public Integer getNbrHeures() {
		return nbrHeures;
	}

	/** Setter
	 * @param nbrHeures the nbrHeures to set
	 */
	public void setNbrHeures(Integer nbrHeures) {
		this.nbrHeures = nbrHeures;
	}

	/** Getter
	 * @return the tarifHoraireStagiaire
	 */
	public Float getTarifHoraireStagiaire() {
		return tarifHoraireStagiaire;
	}

	/** Setter
	 * @param tarifHoraireStagiaire the tarifHoraireStagiaire to set
	 */
	public void setTarifHoraireStagiaire(Float tarifHoraireStagiaire) {
		this.tarifHoraireStagiaire = tarifHoraireStagiaire;
	}

	/** Getter
	 * @return the tarifForfaitaireGroupe
	 */
	public Float getTarifForfaitaireGroupe() {
		return tarifForfaitaireGroupe;
	}

	/** Setter
	 * @param tarifForfaitaireGroupe the tarifForfaitaireGroupe to set
	 */
	public void setTarifForfaitaireGroupe(Float tarifForfaitaireGroupe) {
		this.tarifForfaitaireGroupe = tarifForfaitaireGroupe;
	}
	
	
	
	


}
