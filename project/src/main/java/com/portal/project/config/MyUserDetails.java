package com.portal.project.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portal.project.repository.UserRepository;

@Service
public class MyUserDetails implements UserDetails, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    private String email;
    private String password;
    private Integer user_id;

    private GrantedAuthority grantedAuthority;

    public MyUserDetails(){
        super();
    }

    public MyUserDetails(String email, String password, String role, Integer user_id) {
        this.email = email;
        this.password = password;
        this.user_id = user_id;
        this.grantedAuthority = new SimpleGrantedAuthority(role);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.login(username);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(grantedAuthority);
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    } 

}