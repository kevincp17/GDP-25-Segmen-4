package com.portal.project.controller;

import java.util.List;

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
import com.portal.project.model.Cv;
import com.portal.project.model.User;
import com.portal.project.repository.CVRepository;
import com.portal.project.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("profile")
public class CVRestController {
    @Autowired
    private CVRepository CvRepository;

    @GetMapping("cv")
    public ResponseEntity<Object> get(Model model) {
        List<Cv> data=CvRepository.findAll();
        // model.addAttribute("regions", regionRepository.findAll()); 
        if(data.isEmpty()){
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @GetMapping("cv/{id}")
    public ResponseEntity<Object> getCV(@PathVariable int id) {
        Cv data=CvRepository.findCVByUserId(id);
        if(data!=null){
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @PostMapping("cv/{id}")
    public ResponseEntity<Object> saveCV(@RequestBody Cv cv){
        CvRepository.save(cv);
        Boolean result=CvRepository.findById(cv.getCv_id()).isPresent();
        if(result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }
}