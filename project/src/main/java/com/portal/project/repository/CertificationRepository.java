package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification,Integer>{
    
}
