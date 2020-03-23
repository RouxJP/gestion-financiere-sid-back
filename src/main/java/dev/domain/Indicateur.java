package dev.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "INDICATEUR")
public class Indicateur {
	/** id : int */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/** formateur : Utilisateur */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FORMATEUR")
	private Utilisateur formateur;

	/** nom : String */
	@Column(name = "NOM")
	private String nom;

	/** valeur : double */
	@Column(name = "VALEUR")
	private double valeur;

	/**
	 * 
	 */
	public Indicateur() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param formateur formateur
	 * @param nom nom
	 */
	public Indicateur(Utilisateur formateur, String nom) {
		super();
		this.formateur = formateur;
		this.nom = nom;
	}

	/**
	 * Getter for nom
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
	 * Getter for valeur
	 * 
	 * @return the valeur
	 */
	public double getValeur() {
		return valeur;
	}

	/**
	 * Setter
	 * 
	 * @param valeur the valeur to set
	 */
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	/**
	 * Getter for id
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for formateur
	 * 
	 * @return the formateur
	 */
	public Utilisateur getFormateur() {
		return formateur;
	}

	/**
	 * Setter
	 * 
	 * @param formateur the formateur to set
	 */
	public void setFormateur(Utilisateur formateur) {
		this.formateur = formateur;
	}

}
