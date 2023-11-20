package com.portal.project.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.project.handler.CustomResponse;
import com.portal.project.model.Apply;
// import com.portal.project.model.InterviewUser;
import com.portal.project.repository.ApplyRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class ApplyRestController {
    @Autowired
    private ApplyRepository applyRepository;
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("apply")
    public ResponseEntity<Object> get() {
        List<Apply> data = applyRepository.findAllJobApplies();
        if(data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data tidak ditemukan");
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @PostMapping("apply")
    public ResponseEntity<Object> save(@RequestBody Apply apply) {
        applyRepository.save(apply);
        Boolean result = applyRepository.findById(apply.getApply_id()).isPresent();
        if(result) {
            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }

        @PostMapping("apply/{id}")
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
            String name = newApply.getApplicant().getCv().getName();

            message.setFrom(new InternetAddress("jobportal.amartek@gmail.com"));
            message.setRecipients(MimeMessage.RecipientType.TO, newApply.getApplicant().getEmail());
            message.setSubject("Amartek " + job + " Recruitment Process" + " [" + dtf.format(now) + "] ");

            Integer status = newApply.getStatus().getStatus_id();

            if (status == 5) {
                String htmlContent = "<h1 style=\"color:black;\">Dear " + name + ",</h1>" +

                        "<p style=\"color:black;\">Thank you for your interest joining in AMARTEK. We are delighted to inform you that you're accepted to the position of <b>"
                        + job + "<b>.</p>" +
                        "<p style=\"color:black;\">We welcome you to our team and look forward to starting this exciting journey together.</p>"
                        +
                        "<p style=\"color:black;\">Thanks & Regards,</p>" +
                        "<p style=\"color:black;\">Talent Acquisition • PT. Bumi Amartha Teknologi Mandiri</p>";
                message.setContent(htmlContent, "text/html; charset=utf-8");
                mailSender.send(message);
            }
            if (status == 6) {
                String htmlContent = "<h1 style=\"color:black;\">Dear " + name + ",</h1>" +
                        "<p style=\"color:black;\">Thank you for your interest in the "+job+" role at Amartek. We appreciate the time and effort you invested in applying for this position.</p>" +
                        "<p style=\"color:black;\">After careful consideration, we have decided not to move forward with your application at this time. We received a significant number of applications from qualified candidates like yourself, making this selection process extremely difficult.</p>"
                        +
                        "<p style=\"color:black;\">If you have any feedback for us about our application process, we welcome your input as it helps us learn and improve!</p>"
                        +
                        "<p style=\"color:black;\">We sincerely appreciate your interest in " + job
                        + " and wish you all the best in your job search.</p>"
                        +
                        "<p style=\"color:black;\">Thanks & Regards,</p>" +
                        "<p style=\"color:black;\">Talent Acquisition • PT. Bumi Amartha Teknologi Mandiri</p>";
                message.setContent(htmlContent, "text/html; charset=utf-8");
                mailSender.send(message);
            }

            return CustomResponse.generate(HttpStatus.OK, "berhasil menyimpan data");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "tidak berhasil menyimpan data");
    }

    //getbyid
    @GetMapping("apply/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        List<Apply> newApply=applyRepository.findJobAppliesByUserID(id);
        // Boolean result = applyRepository.findJobAppliesByUserID(id).isEmpty();
        if(newApply.isEmpty()) {
            // List<Apply> newApply = applyRepository.findJobAppliesByUserID(id);
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", newApply);
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", newApply);
    }

    //delete
    @DeleteMapping("apply/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        Boolean result = applyRepository.findById(id).isPresent();
        if(result) {
            applyRepository.deleteById(id);
            return CustomResponse.generate(HttpStatus.OK, "data berhasil dihapus");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil dihapus");
    }
    

}