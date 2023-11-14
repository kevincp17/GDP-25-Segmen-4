package com.portal.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.project.handler.CustomResponse;
import com.portal.project.model.Career;
import com.portal.project.model.User;
import com.portal.project.repository.UserRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class UserRestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("user")
    public ResponseEntity<Object> get(Model model) {
        List<User> data=userRepository.findAll();
        // model.addAttribute("regions", regionRepository.findAll()); 
        if(data.isEmpty()){
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable int id) {
        Optional<User> data=userRepository.findById(id);
        // model.addAttribute("regions", regionRepository.findAll()); 
        if(data.isPresent()){
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }
}