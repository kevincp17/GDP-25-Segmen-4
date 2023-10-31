package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.portal.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT new com.example.demo.config.MyUserDetails(e.email, u.password, r.name) FROM User u JOIN u.employee e JOIN u.role r WHERE e.email = ?1")
    public UserDetails login(String email);
}
