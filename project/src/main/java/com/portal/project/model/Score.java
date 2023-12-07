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
    private String description;

    @ManyToOne
    @JoinColumn(name = "qualification_job_id")
    private QualificationJob qualificationJob;

    @ManyToOne
    @JoinColumn(name = "interview_user_id")
    private InterviewUser interviewUser;

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

    public InterviewUser getInterviewUser() {
        return interviewUser;
    }

    public void setInterviewUser(InterviewUser interviewUser) {
        this.interviewUser = interviewUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}