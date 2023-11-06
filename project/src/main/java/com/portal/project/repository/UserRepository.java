package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.project.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
