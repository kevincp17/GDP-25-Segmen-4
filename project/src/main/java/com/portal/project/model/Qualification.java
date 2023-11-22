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
@Table(name = "tb_m_qualification")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qualification_id")
    private Integer qualification_id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "qualification")
    private Set<QualificationJob> qualificationJobs;

    public Set<QualificationJob> getQualificationJobs() {
        return qualificationJobs;
    }

    public void setQualificationJobs(Set<QualificationJob> qualificationJobs) {
        this.qualificationJobs = qualificationJobs;
    }

    public Integer getQualification_id() {
        return qualification_id;
    }

    public void setQualification_id(Integer qualification_id) {
        this.qualification_id = qualification_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
