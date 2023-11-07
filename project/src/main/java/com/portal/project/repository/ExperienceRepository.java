package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Integer>{
    
}
