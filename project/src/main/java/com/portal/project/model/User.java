package com.portal.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_m_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;
    private String email;
    private String password;
    
    @JsonIgnore
    @OneToOne(mappedBy="user")
    private Cv cv;

    @JsonIgnore
    @OneToMany(mappedBy = "applicant")
    public Set<User> applicant;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "applicant")
    private Set<InterviewUser> interviewApplicants;

    @JsonIgnore
    @OneToMany(mappedBy = "ta")
    private Set<InterviewUser> interviewTAs;

    @JsonIgnore
    @OneToMany(mappedBy = "trainer")
    private Set<InterviewUser> interviewTrainers;

    @JsonIgnore
    @OneToMany(mappedBy = "applicant")
    private Set<Apply> applies;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public Set<User> getApplicant() {
        return applicant;
    }

    public void setApplicant(Set<User> applicant) {
        this.applicant = applicant;
    }

    
    public Set<InterviewUser> getInterviewApplicants() {
        return interviewApplicants;
    }

    public void setInterviewApplicants(Set<InterviewUser> interviewApplicants) {
        this.interviewApplicants = interviewApplicants;
    }

    public Set<InterviewUser> getInterviewTAs() {
        return interviewTAs;
    }

    public void setInterviewTAs(Set<InterviewUser> interviewTAs) {
        this.interviewTAs = interviewTAs;
    }

    public Set<InterviewUser> getInterviewTrainers() {
        return interviewTrainers;
    }

    public void setInterviewTrainers(Set<InterviewUser> interviewTrainers) {
        this.interviewTrainers = interviewTrainers;
    }

    public Set<Apply> getApplies() {
        return applies;
    }

    public void setApplies(Set<Apply> applies) {
        this.applies = applies;
    }  

}
