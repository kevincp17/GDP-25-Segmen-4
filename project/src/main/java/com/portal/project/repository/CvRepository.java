package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Cv;

@Repository
public interface CvRepository extends JpaRepository<Cv, Integer> {
    
}
