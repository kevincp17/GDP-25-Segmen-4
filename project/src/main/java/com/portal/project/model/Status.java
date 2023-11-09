package com.portal.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Integer status_id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private Set<Apply> applies;

    // @JsonIgnore
    // @OneToMany(mappedBy = "status")
    // private Set<InterviewUser> interviewUsers;

    // public Set<InterviewUser> getInterviewUsers() {
    //     return interviewUsers;
    // }

    // public void setInterviewUsers(Set<InterviewUser> interviewUsers) {
    //     this.interviewUsers = interviewUsers;
    // }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Apply> getApplies() {
        return applies;
    }

    public void setApplies(Set<Apply> applies) {
        this.applies = applies;
    }

    // public Set<InterviewUser> getInterviewUsers() {
    //     return interviewUsers;
    // }

    // public void setInterviewUsers(Set<InterviewUser> interviewUsers) {
    //     this.interviewUsers = interviewUsers;
    // }

    

}