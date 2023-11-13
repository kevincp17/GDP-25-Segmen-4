package com.portal.project.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import com.portal.project.handler.CustomResponse;
import com.portal.project.model.Apply;
import com.portal.project.model.Cv;
// import com.portal.project.model.InterviewUser;
import com.portal.project.repository.ApplyRepository;
import com.portal.project.repository.CvRepository;


@RestController
@RequestMapping("api")
@CrossOrigin
public class ApplicationRestController {
    @Autowired
    private ApplyRepository applyRepository;
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("application")
    public ResponseEntity<Object> get() {
        List<Apply> data = applyRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data tidak ditemukan");
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @PostMapping("application/{id}")
    public ResponseEntity<Object> save(@RequestBody Apply apply, @PathVariable(required = true) Integer id)
            throws AddressException, MessagingException {
        Boolean result = applyRepository.findById(id).isPresent();
        if (result) {
            Apply newApply = applyRepository.findById(id).orElse(null);
            newApply.setStatus(apply.getStatus());
            applyRepository.save(newApply);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime now = LocalDateTime.now();

            MimeMessage message = mailSender.createMimeMessage();

            String job = newApply.getCareer().getTitle();

            message.setFrom(new InternetAddress("jobportal.amartek@gmail.com"));
            message.setRecipients(MimeMessage.RecipientType.TO, newApply.getApplicant().getEmail());
            message.setSubject("[" + dtf.format(now) + "] " + "Amartek " + job + " Recruitment Process");

            Integer status = newApply.getStatus().getStatus_id();

            if (status == 5) {
                String htmlContent = "<p>accepted</p>";
                message.setContent(htmlContent, "text/html; charset=utf-8");
                mailSender.send(message);
            } if (status == 6) {
                String htmlContent = "<p>rejected</p>";
                message.setContent(htmlContent, "text/html; charset=utf-8");
                mailSender.send(message);
            }

            return CustomResponse.generate(HttpStatus.OK, "berhasil menyimpan data");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "tidak berhasil menyimpan data");
    }
}