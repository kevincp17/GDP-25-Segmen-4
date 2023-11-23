package com.portal.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.project.handler.CustomResponse;
import com.portal.project.model.Apply;
import com.portal.project.model.Qualification;
import com.portal.project.repository.QualificationRepository;

@CrossOrigin
@RestController
@RequestMapping("api")
public class QualificationRestController {
    @Autowired
    private QualificationRepository qualificationRepository;

    @GetMapping("qualification")
    public ResponseEntity<Object> getStatusCount() {
        List<Qualification> data = qualificationRepository.findAll();
        if(data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data tidak ditemukan", data);
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }
}
