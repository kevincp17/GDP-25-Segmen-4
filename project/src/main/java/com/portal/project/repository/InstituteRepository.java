package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Institute;

@Repository
public interface InstituteRepository extends JpaRepository<Institute,Integer>{
    
}
