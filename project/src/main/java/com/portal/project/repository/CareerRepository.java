package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career,Integer>{
    
}