package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Apply;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Integer>{
    
}
