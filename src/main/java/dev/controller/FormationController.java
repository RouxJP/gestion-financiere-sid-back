package dev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import dev.repository.FormationRepo;

@RestController

public class FormationController {
	
	private FormationRepo formationRepo;
	private static final Logger LOG = LoggerFactory.getLogger(dev.controller.FormationController.class);
	/**
	 * @param formationController
	 */
	public FormationController(FormationRepo formationRepo) {
		super();
		this.formationRepo = formationRepo;
	}

	
}
