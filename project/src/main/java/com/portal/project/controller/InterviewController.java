package com.portal.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("interviews")
public class InterviewController {
    @GetMapping
    public String index(){
        return "interviews/index";
    }
}