package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Formation;

public interface FormationRepo extends JpaRepository<Formation, Long> {
	
	Optional<Formation> findByNom(String nom);
	Optional<Formation> findByDuree(Integer duree);
	Optional<Formation> findByReference(String reference);

}
