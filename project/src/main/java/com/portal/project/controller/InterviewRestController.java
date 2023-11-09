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
import com.portal.project.model.Interview;
import com.portal.project.model.Status;
import com.portal.project.repository.InterviewRepository;
import com.portal.project.repository.StatusRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class InterviewRestController {
    @Autowired
    private InterviewRepository interviewRepository;

    @GetMapping("interview")
    public ResponseEntity<Object> get() {
        List<Interview> data = interviewRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data tidak ditemukan");
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }
}
