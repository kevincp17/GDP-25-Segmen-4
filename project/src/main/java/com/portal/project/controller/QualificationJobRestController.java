package com.portal.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.project.handler.CustomResponse;
import com.portal.project.model.Qualification;
import com.portal.project.model.QualificationJob;
import com.portal.project.model.Skill;
import com.portal.project.repository.QualificationJobRepository;

@CrossOrigin
@RestController
@RequestMapping("api")
public class QualificationJobRestController {
    @Autowired
    private QualificationJobRepository qualificationJobRepository;

    @GetMapping("qualification_job")
    public ResponseEntity<Object> getStatusCount() {
        List<QualificationJob> data = qualificationJobRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data tidak ditemukan", data);
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @GetMapping("qualification_job/{id}")
    public ResponseEntity<Object> getStatusCount(@PathVariable Integer id) {
        List<QualificationJob> data = qualificationJobRepository.findQualificationJobsByApplyId(id);
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data tidak ditemukan", data);
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @PostMapping(value = { "qualification_job", "qualification_job/{id}" })
    public ResponseEntity<Object> save(@PathVariable(required = false) Integer id,
            @RequestBody QualificationJob qualificationJob) {
        qualificationJobRepository.save(qualificationJob);
        Boolean result = qualificationJobRepository.findById(qualificationJob.getQualification_job_id()).isPresent();
        if (id != null) {
            if (result) {
                return CustomResponse.generate(HttpStatus.OK, "data berhasil diupdate",
                        qualificationJobRepository.findById(qualificationJob.getQualification_job_id()));
            }
        } else {
            if (result) {
                return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan",
                        qualificationJobRepository.findById(qualificationJob.getQualification_job_id()));
            }
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }
}
