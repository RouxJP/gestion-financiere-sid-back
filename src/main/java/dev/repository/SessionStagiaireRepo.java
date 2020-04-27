package dev.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Session;
import dev.domain.SessionStagiaire;


public interface SessionStagiaireRepo extends JpaRepository<SessionStagiaire, Long> {

	   List<SessionStagiaire> findBySession(Session session);


    
}
