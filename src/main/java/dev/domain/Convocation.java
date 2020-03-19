package dev.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Représente une convocation pour une session de formation.
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "CONVOCATION")
public class Convocation {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** centre : Centre */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CENTRE")
	private Centre centre;

	/** documentConvocation : DocumentDiginamic */
	@OneToOne
	@JoinColumn(name = "ID_DOC")
	private DocumentDiginamic documentConvocation;

	/** documents : List */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "DOCUMENTS_PAR_CONVOCATION", joinColumns = @JoinColumn(name = "ID_CONVOC", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_DOC", referencedColumnName = "ID"))
	private List<DocumentDiginamic> documents = new ArrayList<>();

	/** mail : String */
	@Column(name = "SUJET_MAIL")
	private String sujetMail;

	/** mail : String */
	@Column(name = "TEXTE_MAIL")
	private String texteMail;

	/** heureArrivee : String */
	@Column(name = "HEURE_ARRIVEE")
	private String heureArrivee;

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
	 * Getter
	 * 
	 * @return the documents
	 */
	public List<DocumentDiginamic> getDocuments() {
		return documents;
	}

	/**
	 * Setter
	 * 
	 * @param documents the documents to set
	 */
	public void setDocuments(List<DocumentDiginamic> documents) {
		this.documents = documents;
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
	 * @param heureArrivee the heureArrivee to set
	 */
	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	/**
	 * Getter
	 * 
	 * @return the sujetMail
	 */
	public String getSujetMail() {
		return sujetMail;
	}

	/**
	 * Setter
	 * 
	 * @param sujetMail the sujetMail to set
	 */
	public void setSujetMail(String sujetMail) {
		this.sujetMail = sujetMail;
	}

	/**
	 * Getter
	 * 
	 * @return the texteMail
	 */
	public String getTexteMail() {
		return texteMail;
	}

	/**
	 * Setter
	 * 
	 * @param texteMail the texteMail to set
	 */
	public void setTexteMail(String texteMail) {
		this.texteMail = texteMail;
	}

	/**
	 * Getter
	 * 
	 * @return the documentConvocation
	 */
	public DocumentDiginamic getDocumentConvocation() {
		return documentConvocation;
	}

	/**
	 * Setter
	 * 
	 * @param documentConvocation the documentConvocation to set
	 */
	public void setDocumentConvocation(DocumentDiginamic documentConvocation) {
		this.documentConvocation = documentConvocation;
	}

}
