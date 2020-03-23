package dev.domain.notation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import dev.domain.Cours;
import dev.domain.CritereNotation;

/**
 * Représente un résultat pour un cours et pour un utilisateur donné. Le résultat englobe toutes les
 * notes de ce cours.
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "RESULTAT_COURS")
public class ResultatCours {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** cours : Cours */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COURS")
	private Cours cours;

	/** bulletin : Bulletin */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BULLETIN")
	private Bulletin bulletin;

	/** notes : List de Note */
	@OneToMany(mappedBy = "idResultat", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Set<Note> notes = new HashSet<>();

	/** appreciation : String */
	@Column(name = "APPRECIATION", length = 1000)
	private String appreciation;

	/** publication : Boolean */
	@Column(name = "PUBLICATION")
	private Boolean publication;

	/** sauvegarde : boolean */
	@Transient
	private boolean sauvegarde;

	/**
	 * Constructor
	 * 
	 */
	public ResultatCours() {

	}

	/**
	 * Constructor
	 * 
	 * @param id identifiant
	 * @param appreciation appréciation
	 */
	public ResultatCours(Long id, String appreciation) {
		this.id = id;
		this.appreciation = appreciation;
	}

	/**
	 * Retourne true si le résultat a une note dont le nom vaut celui passé en paramètre
	 * 
	 * @param nom nom
	 * @return boolean
	 */
	public boolean hasNote(String nom) {
		return notes.stream().anyMatch(n -> n.getCritereNotation().getNom().equals(nom));
	}

	/**
	 * Retourne la note dont le nom est passé en paramètre
	 * 
	 * @param nom nom
	 * @return Optional
	 */
	public Optional<Note> getNote(String nom) {
		return notes.stream().filter(n -> n.getCritereNotation().getNom().equals(nom)).findAny();
	}

	/**
	 * Retourne la note dont le critère est passé en paramètre
	 * 
	 * @param critere critère de notation
	 * @return Optional
	 */
	public Optional<Note> getNote(CritereNotation critere) {
		return notes.stream().filter(n -> n.getCritereNotation().equals(critere)).findAny();
	}

	/**
	 * Compare le critere de notation à une liste de critères de référence. Si le critère passé en
	 * parmètre existe dans la liste alors la méthode retourne true sinon elle retourne false
	 * 
	 * @param critere critère
	 * @param criteresRef critères de référence
	 * @return boolean
	 */
	public boolean critereExiste(CritereNotation critere, Set<CritereNotation> criteresRef) {
		return criteresRef.stream().filter(cref -> cref.equals(critere)).count() >= 1;
	}

	/**
	 * Retourne la liste triée des notes selon les types de critère de notation
	 * 
	 * @return the notes
	 */
	public List<Note> getSortedNotes() {

		List<Note> notes = new ArrayList<>();
		notes.addAll(this.notes);

		Collections.sort(notes);

		return notes;
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
	 * @return the bulletin
	 */
	public Bulletin getBulletin() {
		return bulletin;
	}

	/**
	 * Setter
	 * 
	 * @param bulletin the bulletin to set
	 */
	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}

	/**
	 * Getter
	 * 
	 * @return the notes
	 */
	public Set<Note> getNotes() {
		return notes;
	}

	/**
	 * Setter
	 * 
	 * @param notes the notes to set
	 */
	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	/**
	 * Getter
	 * 
	 * @return the appreciation
	 */
	public String getAppreciation() {
		return appreciation;
	}

	/**
	 * Setter
	 * 
	 * @param appreciation the appreciation to set
	 */
	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}

	/**
	 * Getter
	 * 
	 * @return the cours
	 */
	public Cours getCours() {
		return cours;
	}

	/**
	 * Setter
	 * 
	 * @param cours the cours to set
	 */
	public void setCours(Cours cours) {
		this.cours = cours;
	}

	/**
	 * Getter
	 * 
	 * @return the sauvegarde
	 */
	public boolean isSauvegarde() {
		return sauvegarde;
	}

	/**
	 * Setter
	 * 
	 * @param sauvegarde the sauvegarde to set
	 */
	public void setSauvegarde(boolean sauvegarde) {
		this.sauvegarde = sauvegarde;
	}

	/**
	 * Getter
	 * 
	 * @return the publication
	 */
	public Boolean getPublication() {
		return publication;
	}

	/**
	 * Setter
	 * 
	 * @param publication the publication to set
	 */
	public void setPublication(Boolean publication) {
		this.publication = publication;
	}
}
