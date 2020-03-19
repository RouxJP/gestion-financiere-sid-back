package dev.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Représente un document Diginamic: logo, modèle de bon de commande, etc..
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "DOCUMENT_DIGINAMIC")
@Cacheable(value = true)
public class DocumentDiginamic {

	/** id : Long */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** nom : String */
	@Column(name = "NOM")
	private String nom;

	/** libelle : String */
	@Column(name = "LIBELLE")
	private String libelle;

	/** type : String */
	@Column(name = "TYPE")
	private String type;

	/** contentType : String */
	@Column(name = "CONTENT_TYPE")
	private String contentType;

	/** centre : Centre */
	@ManyToOne
	@JoinColumn(name = "ID_CEN")
	private Centre centre;

	/** file : byte[] */
	@Lob
	@Column(name = "FILE")
	private byte[] file;

	/** selected : boolean */
	@Transient
	private boolean selected;

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof DocumentDiginamic)) {
			return false;
		}
		DocumentDiginamic autre = (DocumentDiginamic) object;
		return new EqualsBuilder().append(this.libelle, autre.libelle).append(this.type, autre.type)
				.append(this.centre, autre.centre).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.libelle).append(this.type).append(this.centre).toHashCode();
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
	 * @return the file
	 */
	public byte[] getFile() {
		return file;
	}

	/**
	 * Setter
	 * 
	 * @param file the file to set
	 */
	public void setFile(byte[] file) {
		this.file = file;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter
	 * 
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter
	 * 
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter
	 * 
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * Setter
	 * 
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
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
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Setter
	 * 
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
