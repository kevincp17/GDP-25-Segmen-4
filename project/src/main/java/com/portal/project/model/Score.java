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
@Table(name = "tb_tr_score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Integer score_id;
    private Float score;

    @ManyToOne
    @JoinColumn(name = "qualification_job_id")
    private QualificationJob qualificationJob;

    @ManyToOne
    @JoinColumn(name = "apply_id")
    private Apply apply;

    public Integer getScore_id() {
        return score_id;
    }

    public void setScore_id(Integer score_id) {
        this.score_id = score_id;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public QualificationJob getQualificationJob() {
        return qualificationJob;
    }

    public void setQualificationJob(QualificationJob qualificationJob) {
        this.qualificationJob = qualificationJob;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }
}