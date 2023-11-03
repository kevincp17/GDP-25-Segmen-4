package com.portal.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.project.handle.CustomResponse;
import com.portal.project.model.Cv;
import com.portal.project.model.CvInfo;
import com.portal.project.repository.CvInfoRepository;
import com.portal.project.repository.CvRepository;

@CrossOrigin
@RestController
@RequestMapping("api")
public class CvInfoRestController {
    @Autowired
    private CvInfoRepository cvInfoRepository;

    @GetMapping("cvinfo/{id}/skill")
    public ResponseEntity<Object> getCVSkill(@PathVariable int id) {
        List<CvInfo> data=cvInfoRepository.findSkillsByCvID(id);
        if(data.isEmpty()){
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @GetMapping("cvinfo/{id}/experience")
    public ResponseEntity<Object> getCVExperience(@PathVariable int id) {
        List<CvInfo> data=cvInfoRepository.findExperiencesByCvID(id);
        if(data.isEmpty()){
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @GetMapping("cvinfo/{id}/education")
    public ResponseEntity<Object> getCVEducation(@PathVariable int id) {
        List<CvInfo> data=cvInfoRepository.findEducationsByCvID(id);
        if(data.isEmpty()){
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @GetMapping("cvinfo/{id}/certificate")
    public ResponseEntity<Object> getCVCertification(@PathVariable int id) {
        List<CvInfo> data=cvInfoRepository.findCertificationByCvID(id);
        if(data.isEmpty()){
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
        }
        // return regionRepository.findAll();
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }
}
