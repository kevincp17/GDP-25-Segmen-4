package com.portal.project.dto;

import java.util.Date;
import com.portal.project.model.Interview;
import com.portal.project.model.InterviewUser;
import com.portal.project.model.User;
import com.portal.project.model.Role;
import com.portal.project.model.Career;

public class InterviewRequest {
    private Integer interview_user_id;
    private Date interview_date;
    private String link;
    private String status;
    // private Integer interview_id;
    // private String interview_name;
    private User user;
    private Role role;
    private Career career;
    private Interview interview;
    

    public InterviewRequest(){

    }

    public InterviewRequest(Date interview_date, String link, Integer interview_id, String interview_name, User user,
            Role role, Career career, Integer interview_user_id, String status, Interview interview) {
        this.interview_date = interview_date;
        this.link = link;
        // this.interview_id = interview_id;
        // this.interview_name = interview_name;
        this.user = user;
        this.role = role;
        this.career = career;
        this.interview_user_id = interview_user_id;
        this.status = status;
        this.interview = interview;
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

    // public Integer getInterview_id() {
    //     return interview_id;
    // }

    // public void setInterview_id(Integer interview_id) {
    //     this.interview_id = interview_id;
    // }

    // public String getInterview_name() {
    //     return interview_name;
    // }

    // public void setInterview_name(String interview_name) {
    //     this.interview_name = interview_name;
    // }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Integer getInterview_user_id() {
        return interview_user_id;
    }

    public void setInterview_user_id(Integer interview_user_id) {
        this.interview_user_id = interview_user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    
    

    
    
    

    
}
