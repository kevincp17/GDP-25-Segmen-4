package com.portal.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_m_cv")
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "cv_id")
    private Integer cv_id;
    private String name;
    private String phone;
    private String address;
    private String photo;

    @OneToOne(mappedBy = "cv")
    private User user;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "experience_id")
    private Experience experience;

    @ManyToOne
    @JoinColumn(name = "education_id")
    private Education education;

    @ManyToOne
    @JoinColumn(name = "certification_id")
    private Certification certification;

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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

}
