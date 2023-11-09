package com.portal.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portal.project.model.Apply;
import com.portal.project.repository.ApplyRepository;
import com.portal.project.repository.UserRepository;

@Controller
@RequestMapping("apply")
public class ApplyController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplyRepository applyRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("applies", applyRepository.findAll());
        return "apply/index";
    }

    // @PostMapping("save")
    // public String save(Apply apply) {
    //     applyRepository.save(apply);
    //     Boolean result = applyRepository.findById(apply.getApply_id()).isPresent();
    //     if(result){
    //         return "redirect:/";
    //     }
    //     return "";
    // }

}
