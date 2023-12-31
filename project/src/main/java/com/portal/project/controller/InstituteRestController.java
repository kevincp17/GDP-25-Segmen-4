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
import com.portal.project.model.Institute;
import com.portal.project.model.Skill;
import com.portal.project.repository.InstituteRepository;

@CrossOrigin
@RestController
@RequestMapping("api")
public class InstituteRestController {
    @Autowired
    private InstituteRepository instituteRepository;

    @GetMapping("institute")
    public ResponseEntity<Object> get() {
        List<Institute> data = instituteRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    // @PostMapping("institute")
    // public ResponseEntity<Object> save(@RequestBody Institute institute) {
    //     instituteRepository.save(institute);
    //     Boolean result = instituteRepository.findById(institute.getInstitute_id()).isPresent();
    //     if(result) {
    //         return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan",instituteRepository.findById(institute.getInstitute_id()));
    //     }
    //     return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    // }

    @PostMapping(value={"institute", "institute/{id}"})
    public ResponseEntity<Object> save(@PathVariable(required = false) Integer id,@RequestBody Institute institute){
        instituteRepository.save(institute);
        Boolean result=instituteRepository.findById(institute.getInstitute_id()).isPresent();
        if(id!=null){
            if (result) {
                return CustomResponse.generate(HttpStatus.OK, "data berhasil diupdate",
                        instituteRepository.findById(institute.getInstitute_id()));
            }
        }
        else{
            if(result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }

    @DeleteMapping("institute/{id}")
    public ResponseEntity<Object> deleteSkill(@PathVariable int id,@RequestBody Institute institute) {
        instituteRepository.delete(institute);
        Boolean result=instituteRepository.findById(institute.getInstitute_id()).isPresent();
        if(!result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil dihapus");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil dihapus");
    }
}
