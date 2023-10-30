package com.portal.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("careers")
public class CareerController {
    @GetMapping
    public String index(){
        return "careers/index";
    }
}
