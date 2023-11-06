package com.portal.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portal.project.repository.InterviewRepository;

@Controller
@RequestMapping("interviews")
public class InterviewController {
    @Autowired 
    private InterviewRepository interviewRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("interviews", interviewRepository.findAll());
        return "interviews/index";
    }
}
