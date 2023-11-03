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
@Table(name="tb_m_experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private Integer exp_id;
    private String company_name;
    private String job_title;
    private String job_desc;
    private Date start_date;
    private Date end_date;

    @JsonIgnore
    @OneToMany(mappedBy = "experience")
    public Set<CvInfo> cvInfos;

    public Integer getExp_id() {
        return exp_id;
    }

    public void setExp_id(Integer exp_id) {
        this.exp_id = exp_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getJob_desc() {
        return job_desc;
    }

    public void setJob_desc(String job_desc) {
        this.job_desc = job_desc;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Set<CvInfo> getCvInfos() {
        return cvInfos;
    }

    public void setCvInfos(Set<CvInfo> cvInfos) {
        this.cvInfos = cvInfos;
    }

}