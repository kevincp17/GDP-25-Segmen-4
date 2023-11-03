package com.portal.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Cv;
import com.portal.project.model.CvInfo;

@Repository
public interface CvInfoRepository extends JpaRepository<CvInfo,Integer>{
    @Query(value = "select  ci.* from tb_tr_cv_info ci,tb_m_cv cv,tb_m_skill s where ci.cv_id=:id AND ci.skill_id=s.skill_id",nativeQuery = true)
    public List<CvInfo> findSkillsByCvID(@Param("id") Integer id); 

    @Query(value = "select  ci.* from tb_tr_cv_info ci,tb_m_cv cv,tb_m_experience e where ci.cv_id=:id AND ci.exp_id=e.exp_id ORDER BY e.start_date DESC",nativeQuery = true)
    public List<CvInfo> findExperiencesByCvID(@Param("id") Integer id); 

    @Query(value = "select ci.* from tb_tr_cv_info ci,tb_m_cv cv,tb_m_education ed where ci.cv_id=:id AND ci.edu_id=ed.edu_id ORDER BY ed.start_date DESC",nativeQuery = true)
    public List<CvInfo> findEducationsByCvID(@Param("id") Integer id); 

    @Query(value = "select  ci.* from tb_tr_cv_info ci,tb_m_cv cv,tb_m_certification c where ci.cv_id=:id AND ci.certification_id=c.certification_id ORDER BY c.issued_date DESC",nativeQuery = true)
    public List<CvInfo> findCertificationByCvID(@Param("id") Integer id); 
}
