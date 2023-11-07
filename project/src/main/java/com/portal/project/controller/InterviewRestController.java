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

import com.portal.project.dto.InterviewRequest;
import com.portal.project.handler.CustomResponse;
import com.portal.project.model.Interview;
import com.portal.project.model.InterviewUser;
import com.portal.project.repository.InterviewRepository;
import com.portal.project.repository.InterviewUserRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class InterviewRestController {
    @Autowired
    private InterviewUserRepository interviewUserRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    @GetMapping("interviews")
    public ResponseEntity<Object> get() {
        List<InterviewUser> data = interviewUserRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data tidak ditemukan");
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @PostMapping("interviews")
    public ResponseEntity<Object> save(@RequestBody InterviewRequest interviewRequest) {
        InterviewUser interview = new InterviewUser();

        interview.setInterview_user_id(interviewRequest.getInterview_user_id());
        interview.setInterview_date(interviewRequest.getInterview_date());
        interview.setLink(interviewRequest.getLink());
        interview.setStatus(interviewRequest.getStatus());
        // interview.setApplicant(interviewRequest);
        // interview.setTa(interviewRequest.getTa());
        // interview.setTrainer(interviewRequest.getTrainer());
        interview.setInterview(interviewRequest.getInterview());

        interviewUserRepository.save(interview);
        Boolean isInterviewUserSaved = interviewUserRepository.findById(interview.getInterview_user_id()).isPresent();
        if (isInterviewUserSaved) {
            // Interview inter = new Interview();

            // inter.setInterview_id(interviewRequest.getInterview_id());
            // inter.setInterview_name(interviewRequest.getInterview_name());
            // inter.setCareer(interviewRequest.getCareer());

            // interviewRepository.save(inter);
            // Boolean isInterviewSaved = interviewRepository.findById(inter.getInterview_id()).isPresent();
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
            // if (isInterviewSaved) {
            //     return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
            // }
            // return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }

    // //getbyid
    // @GetMapping("interviews/{id}")
    // public ResponseEntity<Object> get(@PathVariable(required = true) Integer id)
    // {
    // Boolean result = interviewRepository.findById(id).isPresent();
    // if(result) {
    // InterviewUser newInterview = interviewRepository.findById(id).orElse(null);
    // return CustomResponse.generate(HttpStatus.OK, "data ditemukan",
    // newInterview);
    // }
    // return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak
    // ditemukan");
    // }

    // //delete
    // @DeleteMapping("interviews/{id}")
    // public ResponseEntity<Object> delete(@PathVariable(required = true) Integer
    // id) {
    // Boolean result = interviewRepository.findById(id).isPresent();
    // if(result) {
    // interviewRepository.deleteById(id);
    // return CustomResponse.generate(HttpStatus.OK, "data berhasil dihapus");
    // }
    // return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil
    // dihapus");
    // }
}
