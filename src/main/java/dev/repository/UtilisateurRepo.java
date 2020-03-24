package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
	
	List<Utilisateur> findByAll();
	Optional<Utilisateur> findByNom();
	Optional<Utilisateur> findByPrenom();
	Optional<Utilisateur> findByAdresse();
	Optional<Utilisateur> findByEmail();
	
	
	

}
