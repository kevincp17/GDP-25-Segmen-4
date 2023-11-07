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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_interview")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_id")
    private Integer interview_id;
    private String interview_name;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Career career;

    @JsonIgnore
    @OneToMany(mappedBy = "interview")
    private Set<InterviewUser> interviewUsers;

    public Integer getInterview_id() {
        return interview_id;
    }

    public void setInterview_id(Integer interview_id) {
        this.interview_id = interview_id;
    }

    public Set<InterviewUser> getInterviewUsers() {
        return interviewUsers;
    }

    public void setInterviewUsers(Set<InterviewUser> interviewUsers) {
        this.interviewUsers = interviewUsers;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public String getInterview_name() {
        return interview_name;
    }

    public void setInterview_name(String interview_name) {
        this.interview_name = interview_name;
    }    

    

    
    
    
}
