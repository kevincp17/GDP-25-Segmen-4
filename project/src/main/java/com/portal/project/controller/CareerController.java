package com.portal.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portal.project.repository.CareerRepository;

@Controller
@RequestMapping("careers")
public class CareerController {
    @Autowired
    private CareerRepository careerRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("careers", careerRepository.findAll());
        return "careers/index";
    }
}
