package com.portal.project.dto;

import java.util.Date;
import com.portal.project.model.Interview;
import com.portal.project.model.InterviewUser;
import com.portal.project.model.User;
import com.portal.project.model.Role;
import com.portal.project.model.Status;
import com.portal.project.model.Career;

public class InterviewRequest {
    private Integer interview_user_id;
    private Date interview_date;
    private String link;
    private Role role;
    private Career career;
    private Interview interview;
    private Integer status_id;
    private User applicant;
    private User ta;
    private User trainer;
    private Integer interview_id;
    private String interview_name;

    public InterviewRequest(){

    }

    public InterviewRequest(Integer interview_user_id, Date interview_date, String link, Role role, Career career,
            Interview interview, Integer status_id, User applicant, User ta, User trainer, Integer interview_id,
            String interview_name) {
        this.interview_user_id = interview_user_id;
        this.interview_date = interview_date;
        this.link = link;
        this.role = role;
        this.career = career;
        this.interview = interview;
        this.status_id = status_id;
        this.applicant = applicant;
        this.ta = ta;
        this.trainer = trainer;
        this.interview_id = interview_id;
        this.interview_name = interview_name;
    }

    public Integer getInterview_user_id() {
        return interview_user_id;
    }

    public void setInterview_user_id(Integer interview_user_id) {
        this.interview_user_id = interview_user_id;
    }

    public Date getInterview_date() {
        return interview_date;
    }

    public void setInterview_date(Date interview_date) {
        this.interview_date = interview_date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
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

    public Integer getInterview_id() {
        return interview_id;
    }

    public void setInterview_id(Integer interview_id) {
        this.interview_id = interview_id;
    }

    public String getInterview_name() {
        return interview_name;
    }

    public void setInterview_name(String interview_name) {
        this.interview_name = interview_name;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }
    

    
   
}
