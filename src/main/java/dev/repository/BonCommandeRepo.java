package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Session;
import dev.domain.finance.BonCommande;

public interface BonCommandeRepo extends JpaRepository<BonCommande, Long> {

    List<BonCommande> findBySession(Session session);
     
}
