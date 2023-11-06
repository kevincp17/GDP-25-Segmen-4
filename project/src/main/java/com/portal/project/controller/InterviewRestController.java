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
import com.portal.project.model.InterviewUser;
import com.portal.project.repository.InterviewRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class InterviewRestController {
    @Autowired
    private InterviewRepository interviewRepository;

    @GetMapping("interviews")
    public ResponseEntity<Object> get() {
        List<InterviewUser> data = interviewRepository.findAll();
        if(data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data tidak ditemukan");
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    // @PostMapping("save")
    // public ResponseEntity<Object> save(@RequestBody InterviewUser interviewUser) {
    //     interviewRepository.save(interviewUser);
    //     Boolean result = interviewRepository.findById(interviewUser.getInterview_user_id()).isPresent();
    //     if(result) {
    //         return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
    //     }
    //     return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    // }

    // //getbyid
    // @GetMapping("interviews/{id}")
    // public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
    //     Boolean result = interviewRepository.findById(id).isPresent();
    //     if(result) {
    //         InterviewUser newInterview = interviewRepository.findById(id).orElse(null);
    //         return CustomResponse.generate(HttpStatus.OK, "data ditemukan", newInterview);
    //     }
    //     return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak ditemukan");
    // }

    // //delete
    // @DeleteMapping("interviews/{id}")
    // public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
    //     Boolean result = interviewRepository.findById(id).isPresent();
    //     if(result) {
    //         interviewRepository.deleteById(id);
    //         return CustomResponse.generate(HttpStatus.OK, "data berhasil dihapus");
    //     }
    //     return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil dihapus");
    // }
}

