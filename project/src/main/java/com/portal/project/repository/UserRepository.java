package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portal.project.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "select u.email, r.name FROM tb_m_user u JOIN tb_m_role r ON u.role_id = r.role_id where r.name = 'ta'", nativeQuery = true)
    public User findTaByUser();
}
