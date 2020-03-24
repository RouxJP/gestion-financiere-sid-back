package dev.controller.vm;

import java.util.List;

import dev.domain.RoleCollegue;
import dev.domain.Utilisateur;

public class UtilisateurVM {
	
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	private List<RoleCollegue> role;
	/**
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param telephone
	 * @param email
	 * @param role
	 */
	public UtilisateurVM (Utilisateur utilisateur){
		super();
		this.nom=utilisateur.getNom();
		this.prenom=utilisateur.getPrenom();
		this.adresse=utilisateur.getAdresse();
		this.telephone=utilisateur.getTelephone();
		this.email=utilisateur.getEmail();
		this.role=utilisateur.getRoles();
		
		
		
		
	}
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/** Getter
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/** Getter
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/** Setter
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/** Getter
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/** Setter
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/** Getter
	 * @return the role
	 */
	public List<RoleCollegue> getRole() {
		return role;
	}
	/** Setter
	 * @param role the role to set
	 */
	public void setRole(List<RoleCollegue> role) {
		this.role = role;
	}
	

}
