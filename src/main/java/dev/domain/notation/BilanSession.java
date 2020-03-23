package dev.domain.notation;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.domain.Session;

/**
 * Représente le bilan de la session avec l'appréciation générale de la session ainsi que la date
 * prévue de planification
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "BILAN_SESSION")
public class BilanSession {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	/** datePrevue : LocalDate */
	@Column(name = "DATE_PREVUE")
	private LocalDate datePrevue;

	/** dateEffective : LocalDate */
	@Column(name = "DATE_EFFECTIVE")
	private LocalDate dateEffective;

	/** numero : int */
	@Column(name = "NUMERO")
	private int numero;

	/** appreciation : String */
	@Column(name = "APPRECIATION")
	private String appreciation;

	/** session : Session */
	@ManyToOne
	@JoinColumn(name = "ID_SESSION")
	private Session session;

	/** publication : Boolean */
	@Column(name = "PUBLICATION")
	private Boolean publication;

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
	 * @return the datePrevue
	 */
	public LocalDate getDatePrevue() {
		return datePrevue;
	}

	/**
	 * Setter
	 * 
	 * @param datePrevue the datePrevue to set
	 */
	public void setDatePrevue(LocalDate datePrevue) {
		this.datePrevue = datePrevue;
	}

	/**
	 * Getter
	 * 
	 * @return the dateEffective
	 */
	public LocalDate getDateEffective() {
		return dateEffective;
	}

	/**
	 * Setter
	 * 
	 * @param dateEffective the dateEffective to set
	 */
	public void setDateEffective(LocalDate dateEffective) {
		this.dateEffective = dateEffective;
	}

	/**
	 * Getter
	 * 
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Setter
	 * 
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
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
