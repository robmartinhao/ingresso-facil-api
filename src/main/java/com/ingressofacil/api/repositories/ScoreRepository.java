package com.ingressofacil.api.repositories;

import com.ingressofacil.api.entities.Score;
import com.ingressofacil.api.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
