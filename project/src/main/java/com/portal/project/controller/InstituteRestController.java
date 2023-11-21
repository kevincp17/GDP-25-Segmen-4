package com.portal.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.project.handler.CustomResponse;
import com.portal.project.model.Apply;
import com.portal.project.model.Institute;
import com.portal.project.repository.InstituteRepository;

@CrossOrigin
@RestController
@RequestMapping("api")
public class InstituteRestController {
    @Autowired
    private InstituteRepository instituteRepository;

    @PostMapping("institute")
    public ResponseEntity<Object> save(@RequestBody Institute institute) {
        instituteRepository.save(institute);
        Boolean result = instituteRepository.findById(institute.getInstitute_id()).isPresent();
        if(result) {
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan",instituteRepository.findById(institute.getInstitute_id()));
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }
}
