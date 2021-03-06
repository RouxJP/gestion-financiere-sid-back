package dev.repository;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Session;


public interface SessionRepo extends JpaRepository<Session, Long> {

	   Optional<Session> findByNom(String nom);

		List<Session> findByCentreNomStartingWith(String etablissement);

		
		List<Session> findByFormationNomCertificationStartingWith(String certif);


		List<Session> findByCentreNomStartingWithAndFormationNomStartingWith(String etablissement, String formation);


		List<Session> findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWith(
				String etablissement, String formation, String certif);


		List<Session> findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWithAndSalleNomStartingWith(
				String etablissement, String formation, String certif, String salle);


		List<Session> findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWithAndSalleNomStartingWithAndSocieteNomStartingWith(
				String etablissement, String formation, String certif, String salle, String entreprise);


		List<Session> findByDateDebutBetween(LocalDate ldDateDebut, LocalDate ldDateFin);


		List<Session> findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWithAndSalleNomStartingWithAndSocieteNomStartingWithAndDateDebutBetween(
				String etablissement, String formation, String certif, String salle, String entreprise,
				LocalDate ldDateDebut, LocalDate ldDateFin);

		List<Session> findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWithAndSalleNomStartingWithAndSocieteNomStartingWithAndDateDebutBetweenOrDateFinBetween(
				String etablissement, String formation, String certif, String salle, String entreprise,
				LocalDate ldDateDebut, LocalDate ldDateFin, LocalDate ldDateDebut2, LocalDate ldDateFin2);

		List<Session> findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWithAndSalleNomStartingWithAndSocieteNomStartingWithAndDateFinBetween(
				String etablissement, String formation, String certif, String salle, String entreprise,
				LocalDate ldDateDebut, LocalDate ldDateFin);

    
}
