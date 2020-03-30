package dev.domain;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

/**
 * Représente un rôle d'un utilisateur: administrateur, planificateur,
 * formateur, stagiaire ou visiteur
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "ROLE")
@Cacheable(value = true)
public class Role implements GrantedAuthority {

	/** serialVersionUID : long */
	private static final long serialVersionUID = 5951377624122103098L;

	/** identifiant */
	@Id
	private Long id;

	/** type de rôle */
	@Enumerated(EnumType.STRING)
	private TypeRole type;

	/** Libellé */
	private String libelle;

	/**
	 * Constructor
	 */
	public Role() {

	}

	/**
	 * Constructor
	 * 
	 * @param type
	 *            type de rôle
	 */
	public Role(TypeRole type) {
		this.id = type.getId();
		this.libelle = type.getLibelle();
		this.type = type;
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 *            identifiant
	 * @param type
	 *            type de rôle
	 */
	public Role(Long id, TypeRole type) {
		this.id = id;
		this.type = type;
		this.libelle = type.getLibelle();
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
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter for type
	 * 
	 * @return the type
	 */
	public TypeRole getType() {
		return type;
	}

	/**
	 * Setter
	 * 
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeRole type) {
		this.type = type;
	}

	@Override
	public String getAuthority() {
		return type.name();
	}

	/**
	 * Getter for libelle
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter
	 * 
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
