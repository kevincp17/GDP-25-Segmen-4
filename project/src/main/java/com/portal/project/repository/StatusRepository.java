package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{
    
}
