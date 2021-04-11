package com.codeoftheweb.salvo.Repositories;

import com.codeoftheweb.salvo.Entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
