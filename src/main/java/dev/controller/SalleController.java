package dev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import dev.repository.SalleRepo;

@RestController

public class SalleController {
	
	private SalleRepo salleRepo;
	private static final Logger LOG = LoggerFactory.getLogger(dev.controller.SalleController.class);
	
	/**
	 * @param salleRepo
	 */
	public SalleController(SalleRepo salleRepo) {
		super();
		this.salleRepo = salleRepo;
	}
	
	

}
