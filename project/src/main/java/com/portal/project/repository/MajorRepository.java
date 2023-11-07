package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Major;

@Repository
public interface MajorRepository extends JpaRepository<Major,Integer>{
    
}
