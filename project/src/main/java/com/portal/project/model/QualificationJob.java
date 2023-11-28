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
@Table(name = "tb_tr_qualification_job")
public class QualificationJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qualification_job_id")
    private Integer qualification_job_id;

    @ManyToOne
    @JoinColumn(name = "qualification_id")
    private Qualification qualification;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Career career;

    @JsonIgnore
    @OneToMany(mappedBy = "qualificationJob")
    private Set<QualificationJob> qualificationJob;

    public Integer getQualification_job_id() {
        return qualification_job_id;
    }

    public void setQualification_job_id(Integer qualification_job_id) {
        this.qualification_job_id = qualification_job_id;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public Set<QualificationJob> getQualificationJob() {
        return qualificationJob;
    }

    public void setQualificationJob(Set<QualificationJob> qualificationJob) {
        this.qualificationJob = qualificationJob;
    }
}
