package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Centre;

public interface CentreRepo extends JpaRepository<Centre, Long> {
	
	Optional<Centre> findByNom(String nom);
	Optional<Centre> findByAdresse(String adresse);
	Optional<Centre> findByResponsable(String responsable);

}
