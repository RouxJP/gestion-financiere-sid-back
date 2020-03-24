package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Salle;

public interface SalleRepo extends JpaRepository<Salle, Long> {
	
	Optional<Salle> findByNom(String nom);
	//Optional<Salle> findByCentre(Centre centre);

}
