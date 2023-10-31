package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.project.model.Cv;

public interface CvRepository extends JpaRepository<Cv, Integer> {
    
}
