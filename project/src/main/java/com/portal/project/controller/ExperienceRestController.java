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
import com.portal.project.model.CvInfo;
import com.portal.project.model.Experience;
import com.portal.project.repository.ExperienceRepository;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ExperienceRestController {
    @Autowired
    private ExperienceRepository experienceRepository;

    @GetMapping("experience")
    public ResponseEntity<Object> getCVSkill() {
        List<Experience> data = experienceRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @PostMapping("experience")
    public ResponseEntity<Object> addCVSkill(@RequestBody Experience experience) {
        experienceRepository.save(experience);
        Boolean result = experienceRepository.findById(experience.getExp_id()).isPresent();
        if (result) {
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan",experienceRepository.findById(experience.getExp_id()));
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }
}
