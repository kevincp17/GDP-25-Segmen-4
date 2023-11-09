package com.portal.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.project.handler.CustomResponse;
import com.portal.project.model.Apply;
import com.portal.project.model.Cv;
// import com.portal.project.model.InterviewUser;
import com.portal.project.repository.ApplyRepository;
import com.portal.project.repository.CvRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class ApplicationRestController {
    @Autowired
    private ApplyRepository applyRepository;

    @GetMapping("application")
    public ResponseEntity<Object> get() {
        List<Apply> data = applyRepository.findAll();
        if(data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data tidak ditemukan");
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @PostMapping("application/{id}")
    public ResponseEntity<Object> save(@RequestBody Apply apply, @PathVariable(required = true) Integer id){
        Boolean result = applyRepository.findById(id).isPresent();
        if(result){
            Apply newApply = applyRepository.findById(id).orElse(null);
            newApply.setStatus(apply.getStatus());
            applyRepository.save(newApply);
            return CustomResponse.generate(HttpStatus.OK, "berhasil menyimpan data");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "tidak berhasil menyimpan data");
    }
}