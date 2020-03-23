package dev.domain.notation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Représente le passage d'une certification
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "CERTIFICATION")
public class Certification {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** identificationCandidat : String */
	@Column(name = "IDENTIFIANT_CANDIDAT")
	private String identifiantCandidat;

	/** languePassage : String */
	@Column(name = "LANGUE_PASSAGE")
	private String languePassage;

	/** scoreBlanc1 : String */
	@Column(name = "SCORE_BLANC1")
	private String scoreBlanc1;

	/** scoreBlanc2 : String */
	@Column(name = "SCORE_BLANC2")
	private String scoreBlanc2;

	/** scoreBlanc3 : String */
	@Column(name = "SCORE_BLANC3")
	private String scoreBlanc3;

	/** scoreBlanc4 : String */
	@Column(name = "SCORE_BLANC4")
	private String scoreBlanc4;

	/** scoreBlanc5 : String */
	@Column(name = "SCORE_BLANC5")
	private String scoreBlanc5;

	/** scoreReel : String */
	@Column(name = "SCORE_REEL")
	private String scoreReel;

	/** datePassage : Date de passage */
	@Column(name = "DATE_PASSAGE")
	private String datePassage;

	/** heureArrivee : String */
	@Column(name = "HEURE_ARRIVEE")
	private String heureArrivee;

	/** heurePassage : Heure de passage */
	@Column(name = "HEURE_PASSAGE")
	private String heurePassage;

	/**
	 * Adresse de passage de la certification
	 */
	@Column(name = "ADRESSE_PASSAGE")
	private String adressePassage;

	/**
	 * Nom de l'organisme pour le passage de la certification
	 */
	@Column(name = "NOM_ORGANISME")
	private String nomOrganisme;

	/** bulletin : Bulletin */
	@ManyToOne
	@JoinColumn(name = "ID_BULLETIN")
	private Bulletin bulletin;

	/**
	 * Constructor
	 * 
	 */
	public Certification() {

	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Certification)) {
			return false;
		}
		Certification other = (Certification) object;
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

	/**
	 * Constructor
	 * 
	 * @param bulletin
	 *            bulletin
	 */
	public Certification(Bulletin bulletin) {
		this.bulletin = bulletin;
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
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the datePassage
	 */
	public String getDatePassage() {
		return datePassage;
	}

	/**
	 * Setter
	 * 
	 * @param datePassage
	 *            the datePassage to set
	 */
	public void setDatePassage(String datePassage) {
		this.datePassage = datePassage;
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
	 * @param bulletin
	 *            the bulletin to set
	 */
	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}

	/**
	 * Getter
	 * 
	 * @return the scoreBlanc1
	 */
	public String getScoreBlanc1() {
		return scoreBlanc1;
	}

	/**
	 * Setter
	 * 
	 * @param scoreBlanc1
	 *            the scoreBlanc1 to set
	 */
	public void setScoreBlanc1(String scoreBlanc1) {
		this.scoreBlanc1 = scoreBlanc1;
	}

	/**
	 * Getter
	 * 
	 * @return the scoreBlanc2
	 */
	public String getScoreBlanc2() {
		return scoreBlanc2;
	}

	/**
	 * Setter
	 * 
	 * @param scoreBlanc2
	 *            the scoreBlanc2 to set
	 */
	public void setScoreBlanc2(String scoreBlanc2) {
		this.scoreBlanc2 = scoreBlanc2;
	}

	/**
	 * Getter
	 * 
	 * @return the scoreBlanc3
	 */
	public String getScoreBlanc3() {
		return scoreBlanc3;
	}

	/**
	 * Setter
	 * 
	 * @param scoreBlanc3
	 *            the scoreBlanc3 to set
	 */
	public void setScoreBlanc3(String scoreBlanc3) {
		this.scoreBlanc3 = scoreBlanc3;
	}

	/**
	 * Getter
	 * 
	 * @return the scoreBlanc4
	 */
	public String getScoreBlanc4() {
		return scoreBlanc4;
	}

	/**
	 * Setter
	 * 
	 * @param scoreBlanc4
	 *            the scoreBlanc4 to set
	 */
	public void setScoreBlanc4(String scoreBlanc4) {
		this.scoreBlanc4 = scoreBlanc4;
	}

	/**
	 * Getter
	 * 
	 * @return the scoreBlanc5
	 */
	public String getScoreBlanc5() {
		return scoreBlanc5;
	}

	/**
	 * Setter
	 * 
	 * @param scoreBlanc5
	 *            the scoreBlanc5 to set
	 */
	public void setScoreBlanc5(String scoreBlanc5) {
		this.scoreBlanc5 = scoreBlanc5;
	}

	/**
	 * Getter
	 * 
	 * @return the scoreReel
	 */
	public String getScoreReel() {
		return scoreReel;
	}

	/**
	 * Setter
	 * 
	 * @param scoreReel
	 *            the scoreReel to set
	 */
	public void setScoreReel(String scoreReel) {
		this.scoreReel = scoreReel;
	}

	/**
	 * Getter
	 * 
	 * @return the identifiantCandidat
	 */
	public String getIdentifiantCandidat() {
		return identifiantCandidat;
	}

	/**
	 * Setter
	 * 
	 * @param identifiantCandidat
	 *            the identifiantCandidat to set
	 */
	public void setIdentifiantCandidat(String identifiantCandidat) {
		this.identifiantCandidat = identifiantCandidat;
	}

	/**
	 * Getter
	 * 
	 * @return the heurePassage
	 */
	public String getHeurePassage() {
		return heurePassage;
	}

	/**
	 * Setter
	 * 
	 * @param heurePassage
	 *            the heurePassage to set
	 */
	public void setHeurePassage(String heurePassage) {
		this.heurePassage = heurePassage;
	}

	/**
	 * Getter
	 * 
	 * @return the adressePassage
	 */
	public String getAdressePassage() {
		return adressePassage;
	}

	/**
	 * Setter
	 * 
	 * @param adressePassage
	 *            the adressePassage to set
	 */
	public void setAdressePassage(String adressePassage) {
		this.adressePassage = adressePassage;
	}

	/**
	 * Getter
	 * 
	 * @return the nomOrganisme
	 */
	public String getNomOrganisme() {
		return nomOrganisme;
	}

	/**
	 * Setter
	 * 
	 * @param nomOrganisme
	 *            the nomOrganisme to set
	 */
	public void setNomOrganisme(String nomOrganisme) {
		this.nomOrganisme = nomOrganisme;
	}

	/**
	 * Getter
	 * 
	 * @return the languePassage
	 */
	public String getLanguePassage() {
		return languePassage;
	}

	/**
	 * Setter
	 * 
	 * @param languePassage
	 *            the languePassage to set
	 */
	public void setLanguePassage(String languePassage) {
		this.languePassage = languePassage;
	}

	/**
	 * Getter
	 * 
	 * @return the heureArrivee
	 */
	public String getHeureArrivee() {
		return heureArrivee;
	}

	/**
	 * Setter
	 * 
	 * @param heureArrivee
	 *            the heureArrivee to set
	 */
	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
}
