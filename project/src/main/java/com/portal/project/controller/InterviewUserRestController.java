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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.project.handler.CustomResponse;
import com.portal.project.model.InterviewUser;
import com.portal.project.repository.CareerRepository;
import com.portal.project.repository.CvRepository;
import com.portal.project.repository.InterviewRepository;
import com.portal.project.repository.InterviewUserRepository;
import com.portal.project.repository.RoleRepository;
import com.portal.project.repository.StatusRepository;
import com.portal.project.repository.UserRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class InterviewUserRestController {
    @Autowired
    private InterviewUserRepository interviewUserRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private CvRepository cvRepository;

    @Autowired
    private CareerRepository careerRepository;

    @GetMapping("interviews")
    public ResponseEntity<Object> get() {
        List<InterviewUser> data = interviewUserRepository.findAll();
        if (data.isEmpty()) {
            return CustomResponse.generate(HttpStatus.OK, "data tidak ditemukan");
        }
        return CustomResponse.generate(HttpStatus.OK, "data ditemukan", data);
    }

    @PostMapping("interviews")
    public ResponseEntity<Object> save(@RequestBody InterviewUser interviewUser)
            throws AddressException, MessagingException {
        interviewRepository.save(interviewUser.getInterview());
        Boolean result = interviewRepository.existsById(interviewUser.getInterview().getInterview_id());
        if (result) {
            interviewUserRepository.save(interviewUser);
            Boolean result2 = interviewUserRepository.existsById(interviewUser.getInterview_user_id());

            if (result2) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

                Integer status = statusRepository.findStatusById(interviewUser.getStatus().getStatus_id());

                if (status == 2) {
                    String nameApplicant = cvRepository.findNameById(interviewUser.getApplicant().getUser_id());
                    String nameTA = cvRepository.findNameById(interviewUser.getTa().getUser_id());
                    String date = interviewUserRepository.findInterviewDateById(interviewUser.getInterview_user_id());
                    String link = interviewUserRepository.findLinkById(interviewUser.getInterview_user_id());
                    String time = interviewUserRepository.findInterviewTimeById(interviewUser.getInterview_user_id());
                    String job = careerRepository.findJobById(interviewUser.getInterview().getCareer().getJob_id());

                    MimeMessage messageApplicant = mailSender.createMimeMessage();
                    messageApplicant.setFrom(new InternetAddress("jobportal.amartek@gmail.com"));
                    String emailApplicant = userRepository.findEmailById(interviewUser.getApplicant().getUser_id());
                    messageApplicant.setRecipients(MimeMessage.RecipientType.TO, emailApplicant);
                    messageApplicant.setSubject(
                            "Invitation Online Interview - " + "<b>" + job + "</b>" + "/" + nameApplicant + "["
                                    + dtf.format(now) + "]");
                    String htmlContentApplicant = "<h1 style=\"color:black;\">Dear " + nameApplicant + ",</h1>" +
                            "<hr>" +
                            "<p style=\"color:black;\">Thank you for applying to the " + job
                            + " position at PT. Bumi Amartha Teknologi Mandiri.</p>" +
                            "<p style=\"color:black;\">You are invited for <b>Online Interview HR</b> at:</p>" +
                            "<p style=\"color:black;\"><b>Date:</b> " + date + "</p>" +
                            "<p style=\"color:black;\"><b>Time:</b> " + time + " WIB</p>" +
                            "<p style=\"color:black;\"><b>Link:</b> " + link + "</p>" +
                            "<a href='" + link + "'></a>" +
                            "<p><b>Terms & Condition</b></p>" +
                            "<ul>" +
                            "<li>Commitment : Kindly reply this email or message as attendance confirmation</li>" +
                            "<li>Ontime  : Please attend 10 minutes early</li>" +
                            "<li>Preparation : <b>Prepare your laptop/ phone and internet also make sure the internet is stable.</b></li>"
                            +
                            "</ul>" +
                            "<p style=\"color:black;\">Thank you for using our application.<b>-Admin</b></p>" +
                            "<hr>" +
                            "<p style=\"color:black;\">If the button above does not work, try copying and pasting the URL into your browser. If you continue to have problems, please feel free to contact us at jobportal.amartek@gmail.com</p>";
                    messageApplicant.setContent(htmlContentApplicant, "text/html; charset=utf-8");
                    mailSender.send(messageApplicant);

                    MimeMessage messageTA = mailSender.createMimeMessage();
                    messageTA.setFrom(new InternetAddress("jobportal.amartek@gmail.com"));
                    String emailTA = userRepository.findEmailById(interviewUser.getTa().getUser_id());
                    messageTA.setRecipients(MimeMessage.RecipientType.TO, emailTA);
                    messageTA.setSubject("Invitation Online Interview " + "[" + dtf.format(now) + "]");
                    String htmlContentTA = "<h1 style=\"color:black;\">Dear " + nameTA + ",</h1>" +
                            "<hr>" +
                            "<p style=\"color:black;\">You are invited for <b>Online Interview HR</b> at:</p>" +
                            "<p style=\"color:black;\"><b>Applicant Name:</b> " + nameApplicant + "</p>" +
                            "<p style=\"color:black;\"><b>Job:</b> " + job + "</p>" +
                            "<p style=\"color:black;\"><b>Date:</b> " + date + "</p>" +
                            "<p style=\"color:black;\"><b>Time:</b> " + time + " WIB</p>" +
                            "<p style=\"color:black;\"><b>Link:</b> " + link + "</p>" +
                            "<a href='" + link + "'></a>" +
                            "</ul>" +
                            "<p style=\"color:black;\">Thank you for using our application.<b>-Admin</b></p>" +
                            "<hr>" +
                            "<p style=\"color:black;\">If the button above does not work, try copying and pasting the URL into your browser. If you continue to have problems, please feel free to contact us at jobportal.amartek@gmail.com</p>";
                    messageTA.setContent(htmlContentTA, "text/html; charset=utf-8");
                    mailSender.send(messageTA);
                }
                if (status == 3) {
                    String nameApplicant = cvRepository.findNameById(interviewUser.getApplicant().getUser_id());
                    String nameTrainer = cvRepository.findNameById(interviewUser.getTrainer().getUser_id());
                    String date = interviewUserRepository.findInterviewDateById(interviewUser.getInterview_user_id());
                    String link = interviewUserRepository.findLinkById(interviewUser.getInterview_user_id());
                    String time = interviewUserRepository.findInterviewTimeById(interviewUser.getInterview_user_id());
                    String job = careerRepository.findJobById(interviewUser.getInterview().getCareer().getJob_id());

                    MimeMessage message1 = mailSender.createMimeMessage();
                    message1.setFrom(new InternetAddress("jobportal.amartek@gmail.com"));
                    String emailApplicant = userRepository.findEmailById(interviewUser.getApplicant().getUser_id());
                    message1.setRecipients(MimeMessage.RecipientType.TO, emailApplicant);
                    message1.setSubject(
                            "Invitation Online Interview - " + job + "/" + nameApplicant + "[" + dtf.format(now) + "]");
                    String htmlContent = "<h1 style=\"color:black;\">Dear " + nameApplicant + ",</h1>" +
                            "<hr>" +
                            "<p style=\"color:black;\">You are invited for <b>Online Interview User (Technical Test)</b>:</p>"
                            +
                            "<p style=\"color:black;\"><b>Date:</b> " + date + "</p>" +
                            "<p style=\"color:black;\"><b>User:</b> " + nameTrainer + "</p>" +
                            "<p style=\"color:black;\"><b>Time:</b> " + time + " WIB</p>" +
                            "<p style=\"color:black;\"><b>Link:</b> " + link + "</p>" +
                            "<a href='" + link + "'></a>" +
                            "<p><b>Terms & Condition</b></p>" +
                            "<ul>" +
                            "<li>Commitment : Kindly reply this email or message as attendance confirmation</li>" +
                            "<li>Ontime  : Please attend 10 minutes early</li>" +
                            "<li>Preparation : <b>Prepare your laptop/ phone and internet also make sure the internet is stable.</b></li>"
                            +
                            "</ul>" +
                            "<p style=\"color:black;\">Thank you for using our application.<b>-Admin</b></p>" +
                            "<hr>" +
                            "<p style=\"color:black;\">If the button above does not work, try copying and pasting the URL into your browser. If you continue to have problems, please feel free to contact us at jobportal.amartek@gmail.com</p>";
                    message1.setContent(htmlContent, "text/html; charset=utf-8");
                    mailSender.send(message1);

                    MimeMessage message2 = mailSender.createMimeMessage();
                    message2.setFrom(new InternetAddress("jobportal.amartek@gmail.com"));
                    String emailTrainer = userRepository.findEmailById(interviewUser.getTrainer().getUser_id());
                    message2.setRecipients(MimeMessage.RecipientType.TO, emailTrainer);
                    message2.setSubject("Invitation Online Interview " + "[" + dtf.format(now) + "]");
                    String htmlContent1 = "<h1 style=\"color:black;\">Dear " + nameTrainer + ",</h1>" +
                            "<hr>" +
                            "<p style=\"color:black;\">You are invited for <b>Online Interview User (Technical Test)</b> at:</p>"
                            +
                            "<p style=\"color:black;\"><b>Applicant Name:</b> " + nameApplicant + "</p>" +
                            "<p style=\"color:black;\"><b>Job:</b> " + job + "</p>" +
                            "<p style=\"color:black;\"><b>Date:</b> " + date + "</p>" +
                            "<p style=\"color:black;\"><b>Time:</b> " + time + " WIB</p>" +
                            "<p style=\"color:black;\"><b>Link:</b> " + link + "</p>" +
                            "<a href='" + link + "'></a>" +
                            "<p style=\"color:black;\">Thank you for using our application.<b>-Admin</b></p>" +
                            "<hr>" +
                            "<p style=\"color:black;\">If the button above does not work, try copying and pasting the URL into your browser. If you continue to have problems, please feel free to contact us at jobportal.amartek@gmail.com</p>";
                    message2.setContent(htmlContent1, "text/html; charset=utf-8");
                    mailSender.send(message2);
                }
                if (status == 4) {
                    String nameApplicant = cvRepository.findNameById(interviewUser.getApplicant().getUser_id());
                    String nameTA = cvRepository.findNameById(interviewUser.getTa().getUser_id());
                    String date = interviewUserRepository.findInterviewDateById(interviewUser.getInterview_user_id());
                    String link = interviewUserRepository.findLinkById(interviewUser.getInterview_user_id());
                    String time = interviewUserRepository.findInterviewTimeById(interviewUser.getInterview_user_id());
                    String job = careerRepository.findJobById(interviewUser.getInterview().getCareer().getJob_id());

                    MimeMessage messageApplicant = mailSender.createMimeMessage();
                    messageApplicant.setFrom(new InternetAddress("jobportal.amartek@gmail.com"));
                    String emailApplicant = userRepository.findEmailById(interviewUser.getApplicant().getUser_id());
                    messageApplicant.setRecipients(MimeMessage.RecipientType.TO, emailApplicant);
                    messageApplicant.setSubject(
                            "Amartek Invitation Online HR Discussion - " + job + " ["
                                    + dtf.format(now) + "]");
                    String htmlContentApplicant = "<h1 style=\"color:black;\">Dear " + nameApplicant + ",</h1>" +
                            "<hr>" +
                            "<p style=\"color:black;\">Thank you for applying to the " + job
                            + " position at PT. Bumi Amartha Teknologi Mandiri.</p>" +
                            "<p style=\"color:black;\">You are invited for <b>Online HR Discussion</b> at:</p>" +
                            "<p style=\"color:black;\"><b>Date:</b> " + date + "</p>" +
                            "<p style=\"color:black;\"><b>Time:</b> " + time + " WIB</p>" +
                            "<p style=\"color:black;\"><b>Link:</b> " + link + "</p>" +
                            "<a href='" + link + "'></a>" +
                            "<p><b>Terms & Condition</b></p>" +
                            "<ul>" +
                            "<li>Commitment : Kindly reply this email or message as attendance confirmation</li>" +
                            "<li>Ontime  : Please attend 10 minutes early</li>" +
                            "<li>Preparation : <b>Prepare your laptop/ phone and internet also make sure the internet is stable.</b></li>"
                            +
                            "</ul>" +
                            "<p style=\"color:black;\">Thank you for using our application.<b>-Admin</b></p>" +
                            "<hr>" +
                            "<p style=\"color:black;\">If the button above does not work, try copying and pasting the URL into your browser. If you continue to have problems, please feel free to contact us at jobportal.amartek@gmail.com</p>";
                    messageApplicant.setContent(htmlContentApplicant, "text/html; charset=utf-8");
                    mailSender.send(messageApplicant);

                    MimeMessage messageTA = mailSender.createMimeMessage();
                    messageTA.setFrom(new InternetAddress("jobportal.amartek@gmail.com"));
                    String emailTA = userRepository.findEmailById(interviewUser.getTa().getUser_id());
                    messageTA.setRecipients(MimeMessage.RecipientType.TO, emailTA);
                    messageTA.setSubject("Invitation Online HR Discussion " + "[" + dtf.format(now) + "]");
                    String htmlContentTA = "<h1 style=\"color:black;\">Dear " + nameTA + ",</h1>" +
                            "<hr>" +
                            "<p style=\"color:black;\">You are invited for <b>Online HR Discussion</b> at:</p>" +
                            "<p style=\"color:black;\"><b>Applicant Name:</b> " + nameApplicant + "</p>" +
                            "<p style=\"color:black;\"><b>Job:</b> " + job + "</p>" +
                            "<p style=\"color:black;\"><b>Date:</b> " + date + "</p>" +
                            "<p style=\"color:black;\"><b>Time:</b> " + time + " WIB</p>" +
                            "<p style=\"color:black;\"><b>Link:</b> " + link + "</p>" +
                            "<a href='" + link + "'></a>" +
                            "</ul>" +
                            "<p style=\"color:black;\">Thank you for using our application.<b>-Admin</b></p>" +
                            "<hr>" +
                            "<p style=\"color:black;\">If the button above does not work, try copying and pasting the URL into your browser. If you continue to have problems, please feel free to contact us at jobportal.amartek@gmail.com</p>";
                    messageTA.setContent(htmlContentTA, "text/html; charset=utf-8");
                    mailSender.send(messageTA);
                }
                return CustomResponse.generate(HttpStatus.OK, "email berhasil dikirim");
            }

            return CustomResponse.generate(HttpStatus.OK, "data berhasil disimpan");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak berhasil disimpan");
    }

    @GetMapping("interviews/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        Boolean result = interviewUserRepository.findApplicantByUserID(id).isEmpty();
        if (!result) {
            List<InterviewUser> newInterview = interviewUserRepository.findApplicantByUserID(id);
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", newInterview);
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak ditemukan");
    }

    @GetMapping("interviewsTrainer/{id}")
    public ResponseEntity<Object> getTrainer(@PathVariable(required = true) Integer id) {
        Boolean result = interviewUserRepository.findTrainerByUserID(id).isEmpty();
        if (!result) {
            List<InterviewUser> newInterview = interviewUserRepository.findTrainerByUserID(id);
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", newInterview);
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak ditemukan");
    }

    @GetMapping("interviewsTA/{id}")
    public ResponseEntity<Object> getTA(@PathVariable(required = true) Integer id) {
        Boolean result = interviewUserRepository.findTAByUserID(id).isEmpty();
        if (!result) {
            List<InterviewUser> newInterview = interviewUserRepository.findTAByUserID(id);
            return CustomResponse.generate(HttpStatus.OK, "data ditemukan", newInterview);
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "data tidak ditemukan");
    }
}