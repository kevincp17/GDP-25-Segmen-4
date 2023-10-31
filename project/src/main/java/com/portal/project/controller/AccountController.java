package com.portal.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.portal.project.repository.RoleRepository;
import com.portal.project.repository.UserRepository;
import com.portal.project.dto.RegisterRequest;
import com.portal.project.model.Cv;
import com.portal.project.model.User;

@Controller
@RequestMapping("user")
public class AccountController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    // register
    @GetMapping("register")
    public String form(Model model){

        model.addAttribute("registerRequest", new RegisterRequest());
        model.addAttribute("roles", roleRepository.findAll());
        return "user/register";
    }

    // //save register
    // @PostMapping("save")
    // public String save(@RequestBody RegisterRequest registerRequest){
    //     User user = new User();

    //     user.setUser_id(registerRequest.getUser_id());
    //     user.setEmail(registerRequest.getEmail());
    //     user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
    //     user.setRole(registerRequest.getRole());

    //     userRepository.save(user);
    //     Boolean isSaved = userRepository.findById(user.getUser_id()).isPresent();
    //     if(isSaved){
    //         Cv cv = new Cv();

    //         cv.setCv_id(user.getUser_id());
    //         cv.setName(registerRequest.getName());
    //         cv.setPhone(registerRequest.getPhone());
    //         cv.setAddress(registerRequest.getAddress());
    //         cv.setPhoto(registerRequest.getph);

    //         userRepository.save(user);
    //         Boolean isSaved2 = userRepository.findById(user.getId()).isPresent();
    //         if(isSaved2){
    //             return "redirect:/account";
    //         }
    //         return "redirect:/account";
    //     }
    //     return "redirect:/account";
    // }

}
