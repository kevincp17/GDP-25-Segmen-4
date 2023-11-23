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
@Table(name="tb_m_cv")
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private Integer cv_id;
    private String name; 
    private String phone; 
    private String address; 
    private String photo; 
    
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy="cv")
    public Set<CvInfo> cvInfos;

    @JsonIgnore
    @OneToMany(mappedBy="cv")
    public Set<InterviewUser> interviewUsers;

    @JsonIgnore
    @OneToMany(mappedBy="cv")
    public Set<Apply> appplies;

    public Integer getCv_id() {
        return cv_id;
    }

    public void setCv_id(Integer cv_id) {
        this.cv_id = cv_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<CvInfo> getCvInfos() {
        return cvInfos;
    }

    public void setCvInfos(Set<CvInfo> cvInfos) {
        this.cvInfos = cvInfos;
    }

    public Set<Apply> getAppplies() {
        return appplies;
    }

    public void setAppplies(Set<Apply> appplies) {
        this.appplies = appplies;
    }

    public Set<InterviewUser> getInterviewUsers() {
        return interviewUsers;
    }

    public void setInterviewUsers(Set<InterviewUser> interviewUsers) {
        this.interviewUsers = interviewUsers;
    }

    
}