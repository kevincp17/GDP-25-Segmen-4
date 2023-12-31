package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.portal.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT new com.portal.project.config.MyUserDetails(u.email, u.password, r.name, u.user_id) FROM User u JOIN u.role r WHERE u.email = ?1")
    public UserDetails login(String email);

    @Query(value = "select u.email from tb_m_user u where u.user_id = ?1", nativeQuery = true)
    public String findEmailById(Integer id);

    // @Query(value = "select role_id from tb_m_user where user_id =?1", nativeQuery = true)
    // public Integer findRoleById(Integer id);
    
}
