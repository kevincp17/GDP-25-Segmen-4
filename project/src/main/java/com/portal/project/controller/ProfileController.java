package com.portal.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portal.project.model.Cv;
import com.portal.project.repository.CvRepository;

@Controller
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    private CvRepository cvRepository;

    @GetMapping
    public String index(){
        return "profile/index";
    }

    @GetMapping("profile/{id}")
    public String indexID(@PathVariable int id,Model model){
        Cv data=cvRepository.findCVByUserId(id);
        System.out.println(data.getName());
        model.addAttribute("cv", data);
        return "profile/index";
    }
}