package dev.domain.finance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Représente un type de financement d'une session de formation :
 *    - Pôle emploi, OPCA, Perso, Entreprise, Autre 
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "TYPE_FINANCEMENT")
public class TypeFinancement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** Pôle emploi, OPCA, Perso, Entreprise, Autre */
	@Column(name = "libelle")
	private String libelle;  

	/**
	 * @param id
	 * @param libelle
	 */
	public TypeFinancement(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/** Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


}
