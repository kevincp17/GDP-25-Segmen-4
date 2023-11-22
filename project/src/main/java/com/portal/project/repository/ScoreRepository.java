package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Score;

@Repository
public interface ScoreRepository  extends JpaRepository<Score, Integer>{
    
}
