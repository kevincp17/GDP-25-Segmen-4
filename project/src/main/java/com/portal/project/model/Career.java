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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_tr_job_vacancy")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer job_id;
    private String title;
    private String placement;
    private String description;
    private String requirement;
    private String type;
    @DateTimeFormat(pattern = "YYYY/MM/DD")
    private Date start_post_date;
    private Date end_post_date;
    private Integer salary;

    @JsonIgnore
    @OneToMany(mappedBy = "career")
    private Set<Interview> interviews;

    @JsonIgnore
    @OneToMany(mappedBy = "career")
    private Set<Apply> applies;

    public Integer getJob_id() {
        return job_id;
    }
    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPlacement() {
        return placement;
    }
    public void setPlacement(String placement) {
        this.placement = placement;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRequirement() {
        return requirement;
    }
    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Date getStart_post_date() {
        return start_post_date;
    }
    public void setStart_post_date(Date start_post_date) {
        this.start_post_date = start_post_date;
    }
    public Date getEnd_post_date() {
        return end_post_date;
    }
    public void setEnd_post_date(Date end_post_date) {
        this.end_post_date = end_post_date;
    }
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public Set<Apply> getApplies() {
        return applies;
    }
    public void setApplies(Set<Apply> applies) {
        this.applies = applies;
    }
    public Set<Interview> getInterviews() {
        return interviews;
    }
    public void setInterviews(Set<Interview> interviews) {
        this.interviews = interviews;
    }
    
    
}