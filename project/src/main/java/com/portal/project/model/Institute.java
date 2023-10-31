package com.portal.project.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_m_institute")
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer institute_id;
    private String name;

    
    @OneToMany(mappedBy = "institute")
    public Set<Education> educations;


    public Integer getInstitute_id() {
        return institute_id;
    }


    public void setInstitute_id(Integer institute_id) {
        this.institute_id = institute_id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Set<Education> getEducations() {
        return educations;
    }


    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    
}
