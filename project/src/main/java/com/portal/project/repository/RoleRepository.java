package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    // @Query(value = "select role_id from tb_m_role where role_id = ?1", nativeQuery = true)
    // public Integer findRoleById(Integer id);
}
