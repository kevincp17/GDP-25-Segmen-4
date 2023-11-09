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
import com.portal.project.model.Experience;
import com.portal.project.model.Skill;
import com.portal.project.repository.SkillRepository;

@RestController
@CrossOrigin
@RequestMapping("api")
public class SkillRestController {
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("skill")
    public ResponseEntity<Object> getCVSkill() {
        List<Skill> data = skillRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }
}
