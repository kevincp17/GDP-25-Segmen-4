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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.project.handler.CustomResponse;
import com.portal.project.model.Career;
import com.portal.project.repository.CareerRepository;

@CrossOrigin
@RestController
@RequestMapping("api")
public class CareerRestController {
    @Autowired
    private CareerRepository careerRepository;

     @GetMapping("careers")
    public ResponseEntity<Object> get(Model model) {
        List<Career> data=careerRepository.findAll();
        // model.addAttribute("regions", regionRepository.findAll()); 
        if(data.isEmpty()){
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @GetMapping("careers/{id}")
    public ResponseEntity<Object> getOne(@PathVariable int id){
        Optional<Career> uOptional=careerRepository.findById(id);
        if(uOptional.isPresent()){
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", uOptional);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", uOptional);
    }

    @PostMapping("careers")
    public ResponseEntity<Object> save(@RequestBody Career career){
        careerRepository.save(career);
        Boolean result=careerRepository.findById(career.getJob_id()).isPresent();
        if(result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }
}