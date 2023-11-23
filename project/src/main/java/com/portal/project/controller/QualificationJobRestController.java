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
import com.portal.project.model.Apply;
import com.portal.project.model.Qualification;
import com.portal.project.model.QualificationJob;
import com.portal.project.repository.QualificationJobRepository;
import com.portal.project.repository.QualificationRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class QualificationJobRestController {
    @Autowired
    private QualificationJobRepository qualificationJobRepository;

    @GetMapping("qualification-job")
    public ResponseEntity<Object> get() {
        List<QualificationJob> data = qualificationJobRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data tidak ditemukan");
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @GetMapping("qualification-job/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        List<QualificationJob> newQualificationJobs = qualificationJobRepository.findQualificationJobsByApplyId(id);
        // Boolean result = applyRepository.findJobAppliesByUserID(id).isEmpty();
        if (newQualificationJobs.isEmpty()) {
            // List<Apply> newApply = applyRepository.findJobAppliesByUserID(id);
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", newQualificationJobs);
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", newQualificationJobs);
    }

    @PostMapping("qualification-job")
    public ResponseEntity<Object> save(@RequestBody QualificationJob qualificationJob) {
        qualificationJobRepository.save(qualificationJob);
        Boolean result = qualificationJobRepository.findById(qualificationJob.getQualification_job_id()).isPresent();
        if (result) {
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }
}
