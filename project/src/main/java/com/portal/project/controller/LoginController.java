package com.portal.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portal.project.config.JwtTokenUtil;
import com.portal.project.config.MyUserDetails;
import com.portal.project.dto.LoginRequest;
import com.portal.project.dto.LoginResponse;
import com.portal.project.repository.CvRepository;
import com.portal.project.repository.RoleRepository;
import com.portal.project.repository.UserRepository;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CvRepository cvRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private MyUserDetails myUserDetails;

    // login
    @GetMapping
    public String login(Model model){
        model.addAttribute("loginRequest", new LoginRequest());
        return "login/index";
    }

    //authentication
    @PostMapping("authenticate")
    public String authenticate(LoginRequest loginRequest){
        Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/";
    }

}