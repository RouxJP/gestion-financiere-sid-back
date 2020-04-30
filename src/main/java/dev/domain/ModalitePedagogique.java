package dev.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import dev.domain.finance.ModPedCoutForm;

/**
 * Représente une modalité pédagogique associée à un cours
 * 
 * @author Mélanie
 *
 */
@Entity
@Table(name = "MODALITES_PEDAGOGIQUES")
@Cacheable(value = true)
public class ModalitePedagogique {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	/** nom : String */
	@Column(name = "code", length = 5)
	private String code;

	/** nom : String */
	@Column(name = "nom", length = 100)
	private String nom;

	/** nom : String */
	@Column(name = "commentaires", length = 100)
	private String commentaires;

	/** formateur : Boolean */
	@Column(name = "besoin_formateur")
	private boolean besoinFormateur;

	/** salle : Boolean */
	@Column(name = "besoin_salle")
	private boolean besoinSalle;

	/** horsCentre : boolean */
	@Column(name = "hors_centre")
	private boolean horsCentre;

	/** presentiel : boolean */
	@Column(name = "presentiel")
	private boolean presentiel;

	/** emargement : boolean */
	@Column(name = "emargement")
	private boolean emargement;

	/** Liste des couts formateurs par modalités pédagogiques */
	@OneToMany(mappedBy = "modalitePedagogique", fetch = FetchType.LAZY)
	private List<ModPedCoutForm> modPedCoutForms = new ArrayList<>();

	/**
	 * Constructor
	 * 
	 */
	public ModalitePedagogique() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param nom nom de la modalité
	 */
	public ModalitePedagogique(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ModalitePedagogique)) {
			return false;
		}
		ModalitePedagogique other = (ModalitePedagogique) obj;
		return new EqualsBuilder().append(nom, other.getNom()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nom).toHashCode();
	}

	@Override
	public String toString() {
		return "ModalitePedagogique [id=" + id + ", nom=" + nom + ", formateur=" + besoinFormateur + "]";
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
	 * Getter
	 * 
	 * @return the besoinFormateur
	 */
	public boolean isBesoinFormateur() {
		return besoinFormateur;
	}

	/**
	 * Setter
	 * 
	 * @param besoinFormateur the besoinFormateur to set
	 */
	public void setBesoinFormateur(boolean besoinFormateur) {
		this.besoinFormateur = besoinFormateur;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter
	 * 
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getter
	 * 
	 * @return the commentaires
	 */
	public String getCommentaires() {
		return commentaires;
	}

	/**
	 * Setter
	 * 
	 * @param commentaires the commentaires to set
	 */
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	/**
	 * Getter
	 * 
	 * @return the horsCentre
	 */
	public boolean isHorsCentre() {
		return horsCentre;
	}

	/**
	 * Setter
	 * 
	 * @param horsCentre the horsCentre to set
	 */
	public void setHorsCentre(boolean horsCentre) {
		this.horsCentre = horsCentre;
	}

	/**
	 * Getter
	 * 
	 * @return the presentiel
	 */
	public boolean isPresentiel() {
		return presentiel;
	}

	/**
	 * Setter
	 * 
	 * @param presentiel the presentiel to set
	 */
	public void setPresentiel(boolean presentiel) {
		this.presentiel = presentiel;
	}

	/**
	 * Getter
	 * 
	 * @return the emargement
	 */
	public boolean isEmargement() {
		return emargement;
	}

	/**
	 * Setter
	 * 
	 * @param emargement the emargement to set
	 */
	public void setEmargement(boolean emargement) {
		this.emargement = emargement;
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
