package com.portal.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.project.handler.CustomResponse;
import com.portal.project.model.Certification;
import com.portal.project.model.Education;
import com.portal.project.repository.CertificationRepository;

@CrossOrigin
@RestController
@RequestMapping("api")
public class CertificationRestController {
    @Autowired
    private CertificationRepository certificationRepository;

    @GetMapping("certification")
    public ResponseEntity<Object> getCVSkill() {
        List<Certification> data = certificationRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @PostMapping("certification")
    public ResponseEntity<Object> addCVSkill(@RequestBody Certification certification) {
        certificationRepository.save(certification);
        Boolean result = certificationRepository.findById(certification.getCertification_id()).isPresent();
        if (result) {
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan",certificationRepository.findById(certification.getCertification_id()));
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }
}
