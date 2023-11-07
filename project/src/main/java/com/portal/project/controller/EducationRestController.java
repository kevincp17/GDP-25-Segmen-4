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
import com.portal.project.model.Degree;
import com.portal.project.model.Education;
import com.portal.project.model.Experience;
import com.portal.project.model.Institute;
import com.portal.project.model.Major;
import com.portal.project.repository.DegreeRepository;
import com.portal.project.repository.EducationRepository;
import com.portal.project.repository.InstituteRepository;
import com.portal.project.repository.MajorRepository;

@CrossOrigin
@RequestMapping("api")
@RestController
public class EducationRestController {
    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private MajorRepository majorRepository;

    @Autowired
    private DegreeRepository degreeRepository;

    @Autowired
    private InstituteRepository instituteRepository;

    @GetMapping("education")
    public ResponseEntity<Object> getCVSkill() {
        List<Education> data = educationRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @PostMapping("education")
    public ResponseEntity<Object> addCVSkill(@RequestBody Education education) {
        educationRepository.save(education);
        Boolean result = educationRepository.findById(education.getEdu_id()).isPresent();
        if (result) {
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan",educationRepository.findById(education.getEdu_id()));
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }

    @GetMapping("education/major")
    public ResponseEntity<Object> getEduMajor() {
        List<Major> data = majorRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @GetMapping("education/degree")
    public ResponseEntity<Object> getEduDegree() {
        List<Degree> data = degreeRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @GetMapping("education/institute")
    public ResponseEntity<Object> getEduInstitute() {
        List<Institute> data = instituteRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }
}
