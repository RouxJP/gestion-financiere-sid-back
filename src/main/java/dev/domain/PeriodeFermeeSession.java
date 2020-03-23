package dev.domain;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente des jours fermés spécifiques à la session
 * 
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name = "PERIODE_FERMEE_SESSION")
@Cacheable(value = true)
public class PeriodeFermeeSession  implements Cloneable {

	/** session : Session */
	@ManyToOne
	@JoinColumn(name = "ID_SESSION")
	private Session session;

	/**
	 * Constructeur
	 */
	public PeriodeFermeeSession() {
		super();
	}


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
}
