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
import com.portal.project.model.Qualification;
import com.portal.project.model.QualificationJob;
import com.portal.project.model.Skill;
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

    @PostMapping(value = { "qualification", "qualification/{id}" })
    public ResponseEntity<Object> save(@PathVariable(required = false) Integer id,
            @RequestBody Qualification qualification) {
        qualificationRepository.save(qualification);
        Boolean result = qualificationRepository.findById(qualification.getQualification_id()).isPresent();
        if (id != null) {
            if (result) {
                return CustomResponse.generate(HttpStatus.OK, "data berhasil diupdate",
                        qualificationRepository.findById(qualification.getQualification_id()));
            }
        } else {
            if (result) {
                return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan",
                        qualificationRepository.findById(qualification.getQualification_id()));
            }
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }

    @DeleteMapping("qualification/{id}")
    public ResponseEntity<Object> deleteSkill(@PathVariable int id,@RequestBody Qualification qualification) {
        qualificationRepository.delete(qualification);
        Boolean result=qualificationRepository.findById(qualification.getQualification_id()).isPresent();
        if(!result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil dihapus");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil dihapus");
    }
}
