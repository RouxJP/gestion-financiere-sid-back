package dev.domain;

/**
 * Type de cours
 * 
 * @author DIGINAMIC
 *
 */
public enum TypeLibelleCours {

	/** CULTURE_DEV : TypeLibelleCours */
	CULTURE_DEV("Culture du développeur"),
	/** COMMUNICATION_REL_1 : TypeLibelleCours */
	COMMUNICATION_REL_1("Communication relationnelle en entreprise - J1"),
	/** COMMUNICATION_REL_2 : TypeLibelleCours */
	COMMUNICATION_REL_2("Communication relationnelle en entreprise - J2"),
	/** COMMUNICATION_REL_12 : TypeLibelleCours */
	COMMUNICATION_REL_12("Communication relationnelle en entreprise - J1 & J2"),
	/** COMMUNICATION_REL_3 : TypeLibelleCours */
	COMMUNICATION_REL_3("Communication relationnelle en entreprise - J3"),
	/** COMMUNICATION_REL_4 : TypeLibelleCours */
	COMMUNICATION_REL_4("Communication relationnelle en entreprise - J4"),
	/** COMMUNICATION_REL_34 : TypeLibelleCours */
	COMMUNICATION_REL_34("Communication relationnelle en entreprise - J3 & J4"),
	/** AGILITE : TypeLibelleCours */
	AGILITE("Introduction à l'agilité"),
	/** JAVA_IMP : TypeLibelleCours */
	JAVA_IMP("Langage Java - Approche impérative"),
	/** JAVA_OBJ : TypeLibelleCours */
	JAVA_OBJ("Langage Java - Approche orientée objet"),
	/** JAVA8 : TypeLibelleCours */
	JAVA8("Langage Java - Spécificités de Java 8"),
	/** GIT_GITHUB : TypeLibelleCours */
	GIT_GITHUB("Outils - Gestion des sources avec Git et pratique de Github"),
	/** MAVEN : TypeLibelleCours */
	MAVEN("Outils - Maven - Gestion du cycle de vie d'un projet"),
	/** UX_DESIGN : TypeLibelleCours */
	UX_DESIGN("Méthodologie - UX/Design"),
	/** PREP_CERTIF : TypeLibelleCours */
	PREP_CERTIF("Préparation certification Java 8"),
	/** INTEGRATION_CONTINUE : TypeLibelleCours */
	INTEGRATION_CONTINUE("Outils - Intégration Continue avec Jenkins + Sonar + Nexus"),
	/** BONNES_PRATIQUES : TypeLibelleCours */
	BONNES_PRATIQUES("Langage Java - Tests unitaires, logging et bonnes pratiques"),
	/** SQL : TypeLibelleCours */
	SQL("Langage SQL - Pratique de MySQL (ou PostgreSQL)"),
	/** JDBC_JPA : TypeLibelleCours */
	JDBC_JPA("Langage Java - JDBC & JPA"),
	/** HTTP_HTML5 : TypeLibelleCours */
	HTTP_HTML5("Front - HTTP & HTML5"),
	/** JAVASCRIPT : TypeLibelleCours */
	JAVASCRIPT("Front - Introduction à JavaScript (sans jquery)"),
	/** CSS : TypeLibelleCours */
	CSS("Front - Introduction à CSS"),
	/** TWITTER_BOOTSTRAP : TypeLibelleCours */
	TWITTER_BOOTSTRAP("Front - Frameworks CSS : Twitter Bootstrap"),
	/** JAVA_EE : TypeLibelleCours */
	JAVA_EE("Langage Java - Développement Web avec Java EE (Servlet, JSP, TagLibs)"),
	/** SPRING_CORE : TypeLibelleCours */
	SPRING_CORE("Spring Framework - Core"),
	/** SPRING_ORM : TypeLibelleCours */
	SPRING_ORM("Spring Framework - Accès aux données (JDBC, ORM & Data)"),
	/** SPRING_JPA : TypeLibelleCours */
	SPRING_JPA("Spring Framework - AOP"),
	/** SPRING_WEB : TypeLibelleCours */
	SPRING_WEB("Spring Framework - Présentation (Web, MVC & Services REST)"),
	/** SPRING_SEC_BOOT : TypeLibelleCours */
	SPRING_SEC_BOOT("Spring Framework - Boot & Security"),
	/** NODEJS : TypeLibelleCours */
	NODEJS("Front - Outillage Front-End (NodeJS, NPM,...)"),
	/** JAVASCRIPT_ADV : TypeLibelleCours */
	JAVASCRIPT_ADV("Front - Javascript avancés"),
	/** ANGULAR : TypeLibelleCours */
	ANGULAR("Front - Développer des applications Web riches avec Angular"),
	/** TESTS_FRONT : TypeLibelleCours */
	TESTS_FRONT("Front - Test front (Jasmine, Karma, Protractor)"),
	/** MISE_EN_PLACE_SCRUM : TypeLibelleCours */
	MISE_EN_PLACE_SCRUM("Méthodologie - Mise en place de Scrum"),
	/** PROJET_FIN_FORMATION : TypeLibelleCours */
	PROJET_FIN_FORMATION("Projet de fin de formation");

	/** libelle : String */
	private String libelle;

	/**
	 * Constructor
	 * 
	 * @param libelle
	 *            libellé
	 */
	private TypeLibelleCours(String libelle) {
		this.libelle = libelle;
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
