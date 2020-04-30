package dev.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.CoursPlanifie;
import dev.domain.Session;


public interface CoursPlanifieRepo extends JpaRepository<CoursPlanifie, Long> {

	   List<CoursPlanifie> findBySession(Session session);


    
}
