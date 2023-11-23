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
import com.portal.project.model.Career;
import com.portal.project.model.CvInfo;
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

    @PostMapping(value={"skill", "skill/{id}"})
    public ResponseEntity<Object> save(@PathVariable(required = false) Integer id,@RequestBody Skill skill){
        skillRepository.save(skill);
        Boolean result=skillRepository.findById(skill.getSkill_id()).isPresent();
        if(id!=null){
            if (result) {
                return CustomResponse.generate(HttpStatus.OK, "data berhasil diupdate",
                        skillRepository.findById(skill.getSkill_id()));
            }
        }
        else{
            if(result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }

    @DeleteMapping("skill/{id}")
    public ResponseEntity<Object> deleteSkill(@PathVariable int id,@RequestBody Skill skill) {
        skillRepository.delete(skill);
        Boolean result=skillRepository.findById(skill.getSkill_id()).isPresent();
        if(!result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil dihapus");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil dihapus");
    }
}