package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.project.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
