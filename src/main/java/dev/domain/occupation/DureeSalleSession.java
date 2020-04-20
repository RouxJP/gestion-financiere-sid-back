package dev.domain.occupation;

/** 
 * Sert à établir une liste de salles avec leur durée d'utilisation pour une session de formation 
 * */

public class DureeSalleSession {
	private String 	nomSalle ;
	private int		dureeUtilisation ;
	
	/**
	 * @param nomSalle
	 * @param dureeUtilisation
	 */
	public DureeSalleSession(String nomSalle, int dureeUtilisation) {
		super();
		this.nomSalle = nomSalle;
		this.dureeUtilisation = dureeUtilisation;
	}
	
	/** Getter
	 * @return the nomSalle
	 */
	public String getNomSalle() {
		return nomSalle;
	}
	/** Setter
	 * @param nomSalle the nomSalle to set
	 */
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	/** Getter
	 * @return the dureeUtilisation
	 */
	public int getDureeUtilisation() {
		return dureeUtilisation;
	}
	/** Setter
	 * @param dureeUtilisation the dureeUtilisation to set
	 */
	public void setDureeUtilisation(int dureeUtilisation) {
		this.dureeUtilisation = dureeUtilisation;
	}
	
}
