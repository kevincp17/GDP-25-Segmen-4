package com.portal.project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Qualification;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification,Integer>{
    
}
