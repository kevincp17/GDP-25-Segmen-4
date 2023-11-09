package com.portal.project.model;

import java.util.Date;
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
@Table(name="tb_m_certification")
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certification_id")
    private Integer certification_id;
    private String certification_name;
    private String certification_number;
    private String organizer_name;
    private Date issued_date;

    @JsonIgnore
    @OneToMany(mappedBy = "certification")
    public Set<CvInfo> cvInfos;

    public Integer getCertification_id() {
        return certification_id;
    }

    public void setCertification_id(Integer certification_id) {
        this.certification_id = certification_id;
    }

    public String getCertification_name() {
        return certification_name;
    }

    public void setCertification_name(String certification_name) {
        this.certification_name = certification_name;
    }

    public String getCertification_number() {
        return certification_number;
    }

    public void setCertification_number(String certification_number) {
        this.certification_number = certification_number;
    }

    public String getOrganizer_name() {
        return organizer_name;
    }

    public void setOrganizer_name(String organizer_name) {
        this.organizer_name = organizer_name;
    }

    public Date getIssued_date() {
        return issued_date;
    }

    public void setIssued_date(Date issued_date) {
        this.issued_date = issued_date;
    }

    public Set<CvInfo> getCvInfos() {
        return cvInfos;
    }

    public void setCvInfos(Set<CvInfo> cvInfos) {
        this.cvInfos = cvInfos;
    }

    

    
}