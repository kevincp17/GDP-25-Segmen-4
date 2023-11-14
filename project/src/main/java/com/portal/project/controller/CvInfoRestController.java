package com.portal.project.controller;

import java.util.List;
import java.util.Optional;

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
import com.portal.project.model.Cv;
import com.portal.project.model.CvInfo;
import com.portal.project.repository.CvInfoRepository;
import com.portal.project.repository.CVRepository;

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

    @PostMapping("cvinfo/{id}/skill")
    public ResponseEntity<Object> addCVSkill(@PathVariable int id,@RequestBody CvInfo cvInfo) {
        cvInfoRepository.save(cvInfo);
        Boolean result=cvInfoRepository.findById(cvInfo.getCv_info_id()).isPresent();
        if(result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
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

    @PostMapping("cvinfo/{id}/experience")
    public ResponseEntity<Object> addCVExperience(@PathVariable int id,@RequestBody CvInfo cvInfo) {
        cvInfoRepository.save(cvInfo);
        Boolean result=cvInfoRepository.findById(cvInfo.getCv_info_id()).isPresent();
        if(result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
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

    @PostMapping("cvinfo/{id}/education")
    public ResponseEntity<Object> addCVEducation(@PathVariable int id,@RequestBody CvInfo cvInfo) {
        cvInfoRepository.save(cvInfo);
        Boolean result=cvInfoRepository.findById(cvInfo.getCv_info_id()).isPresent();
        if(result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
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

    @PostMapping("cvinfo/{id}/certificate")
    public ResponseEntity<Object> addCVCertification(@PathVariable int id,@RequestBody CvInfo cvInfo) {
        cvInfoRepository.save(cvInfo);
        Boolean result=cvInfoRepository.findById(cvInfo.getCv_info_id()).isPresent();
        if(result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }

    @DeleteMapping("cvinfo/{cvId}/skill/{s_id}")
    public ResponseEntity<Object> deleteSkillCertification(@PathVariable int cvId,@PathVariable int s_id,@RequestBody CvInfo cvInfo) {
        cvInfoRepository.delete(cvInfo);
        Boolean result=cvInfoRepository.FindSkillByCvID(cvId,s_id).isPresent();
        if(!result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil dihapus");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil dihapus");
    }

    @DeleteMapping("cvinfo/{cvId}/experience/{expId}")
    public ResponseEntity<Object> deleteExperience(@PathVariable int cvId,@PathVariable int expId,@RequestBody CvInfo cvInfo) {
        cvInfoRepository.delete(cvInfo);
        Boolean result=cvInfoRepository.FindExpByCvID(cvId,expId).isPresent();
        if(!result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil dihapus");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil dihapus");
    }

    @DeleteMapping("cvinfo/{cvId}/education/{eduId}")
    public ResponseEntity<Object> deleteEducation(@PathVariable int cvId,@PathVariable int eduId,@RequestBody CvInfo cvInfo) {
        cvInfoRepository.delete(cvInfo);
        Boolean result=cvInfoRepository.FindEduByCvID(cvId,eduId).isPresent();
        if(!result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil dihapus");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil dihapus");
    }

    @DeleteMapping("cvinfo/{cvId}/certification/{certId}")
    public ResponseEntity<Object> deleteCertification(@PathVariable int cvId,@PathVariable int certId,@RequestBody CvInfo cvInfo) {
        cvInfoRepository.delete(cvInfo);
        Boolean result=cvInfoRepository.FindCertByCvID(cvId,certId).isPresent();
        if(!result){
            return CustomResponse.generate(HttpStatus.OK, "data berhasil dihapus");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil dihapus");
    }
}
