// package com.portal.project.model;

// import java.util.Date;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;

// @Entity
// @Table(name = "tb_tr_interview_user")
// public class InterviewUser {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "interview_user_id")
//     private Integer interview_user_id;
//     private Date interview_date;
//     private String link;
     
//     @ManyToOne
//     @JoinColumn(name = "interview_id")
//     private Interview interview;

//     @ManyToOne
//     @JoinColumn(name = "applicant_id", referencedColumnName = "user_id")
//     private User applicant;

//     @ManyToOne
//     @JoinColumn(name = "ta_id", referencedColumnName = "user_id")
//     private User ta;

//     @ManyToOne
//     @JoinColumn(name = "trainer_id", referencedColumnName = "user_id")
//     private User trainer;

//     public Integer getInterview_user_id() {
//         return interview_user_id;
//     }

//     public void setInterview_user_id(Integer interview_user_id) {
//         this.interview_user_id = interview_user_id;
//     }

//     public Date getInterview_date() {
//         return interview_date;
//     }

//     public void setInterview_date(Date interview_date) {
//         this.interview_date = interview_date;
//     }

//     public String getLink() {
//         return link;
//     }

//     public void setLink(String link) {
//         this.link = link;
//     }

//     public Interview getInterview() {
//         return interview;
//     }

//     public void setInterview(Interview interview) {
//         this.interview = interview;
//     }

//     public User getApplicant() {
//         return applicant;
//     }

//     public void setApplicant(User applicant) {
//         this.applicant = applicant;
//     }

//     public User getTa() {
//         return ta;
//     }

//     public void setTa(User ta) {
//         this.ta = ta;
//     }

//     public User getTrainer() {
//         return trainer;
//     }

//     public void setTrainer(User trainer) {
//         this.trainer = trainer;
//     }

    
    
    
// }