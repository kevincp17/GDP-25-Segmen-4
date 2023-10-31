package com.portal.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portal.project.repository.CvRepository;
import com.portal.project.repository.RoleRepository;
import com.portal.project.repository.UserRepository;
import com.portal.project.dto.LoginRequest;
import com.portal.project.dto.RegisterRequest;
import com.portal.project.model.Cv;
import com.portal.project.model.User;

@Controller
@RequestMapping("register")
public class RegisterController {
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
    
    // register
    @GetMapping
    public String register(Model model){
        model.addAttribute("registerRequest", new RegisterRequest());
        model.addAttribute("roles", roleRepository.findAll());
        return "register/index";
    }

    //save register
    @PostMapping("save")
    public String save(RegisterRequest registerRequest){
        User user = new User();

        user.setUser_id(registerRequest.getUser_id());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(registerRequest.getRole());

        userRepository.save(user);
        Boolean isUserSaved = userRepository.findById(user.getUser_id()).isPresent();
        if(isUserSaved){
            Cv cv = new Cv();

            cv.setCv_id(user.getUser_id());
            cv.setName(registerRequest.getName());
            cv.setPhone(registerRequest.getPhone());
            cv.setAddress(registerRequest.getAddress());
            cv.setPhoto(registerRequest.getPhoto());

            cvRepository.save(cv);
            Boolean isCvSaved = cvRepository.findById(cv.getCv_id()).isPresent();
            if(isCvSaved){
                return "redirect:/register";
            }
            return "redirect:/register";
        }
        return "redirect:/register";
    }
}
