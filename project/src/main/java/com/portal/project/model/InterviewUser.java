package com.portal.project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_tr_interview_user")
public class InterviewUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_user_id")
    private Integer interview_user_id;
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime interview_date;
    private String link;
     
    @ManyToOne
    @JoinColumn(name = "interview_id")
    private Interview interview;

    @ManyToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "user_id")
    private User applicant;

    @ManyToOne
    @JoinColumn(name = "ta_id", referencedColumnName = "user_id")
    private User ta;

    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "user_id")
    private User trainer;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;

    @ManyToOne
    @JoinColumn(name = "cv_trainer_id")
    private Cv cv_trainer;

    @ManyToOne
    @JoinColumn(name = "cv_ta_id")
    private Cv cv_ta;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "apply_id")
    private Apply apply;

    @JsonIgnore
    @OneToMany(mappedBy = "interviewUser")
    private Set<Score> scores;

    public Integer getInterview_user_id() {
        return interview_user_id;
    }

    public void setInterview_user_id(Integer interview_user_id) {
        this.interview_user_id = interview_user_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public User getTa() {
        return ta;
    }

    public void setTa(User ta) {
        this.ta = ta;
    }

    public User getTrainer() {
        return trainer;
    }

    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getInterview_date() {
        return interview_date;
    }

    public void setInterview_date(LocalDateTime interview_date) {
        this.interview_date = interview_date;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public Cv getCv_trainer() {
        return cv_trainer;
    }

    public void setCv_trainer(Cv cv_trainer) {
        this.cv_trainer = cv_trainer;
    }

    public Cv getCv_ta() {
        return cv_ta;
    }

    public void setCv_ta(Cv cv_ta) {
        this.cv_ta = cv_ta;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }
}
