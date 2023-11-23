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
import com.portal.project.model.Degree;
import com.portal.project.model.Institute;
import com.portal.project.model.Major;
import com.portal.project.repository.MajorRepository;

@CrossOrigin
@RestController
@RequestMapping("api")
public class MajorRestController {
    @Autowired
    private MajorRepository majorRepository;

    @GetMapping("major")
    public ResponseEntity<Object> get() {
        List<Major> data = majorRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @PostMapping(value={"major", "major/{id}"})
    public ResponseEntity<Object> save(@PathVariable(required = false) Integer id,@RequestBody Major major){
        majorRepository.save(major);
        Boolean result=majorRepository.findById(major.getMajor_id()).isPresent();
        if(id!=null){
            if (result) {
                return CustomResponse.generate(HttpStatus.OK, "data berhasil diupdate",
                        majorRepository.findById(major.getMajor_id()));
            }
        }
        else{
            if(result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }

    @DeleteMapping("major/{id}")
    public ResponseEntity<Object> deleteSkill(@PathVariable int id,@RequestBody Major major) {
        majorRepository.delete(major);
        Boolean result=majorRepository.findById(major.getMajor_id()).isPresent();
        if(!result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil dihapus");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil dihapus");
    }
}
