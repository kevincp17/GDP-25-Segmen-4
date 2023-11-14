package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree,Integer>{
    
}