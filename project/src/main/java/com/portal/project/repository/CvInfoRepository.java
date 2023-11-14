package com.portal.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Cv;
import com.portal.project.model.CvInfo;

@Repository
public interface CvInfoRepository extends JpaRepository<CvInfo,Integer>{
    @Query(value = "select ci.* from tb_tr_cv_info ci,tb_m_cv cv,tb_m_skill s where ci.cv_id=:id AND cv.user_id=:id AND ci.skill_id=s.skill_id",nativeQuery = true)
    public List<CvInfo> findSkillsByCvID(@Param("id") Integer id); 

    @Query(value = "select ci.* from tb_tr_cv_info ci,tb_m_cv cv,tb_m_experience e where ci.cv_id=:id AND cv.user_id=:id AND ci.exp_id=e.exp_id ORDER BY e.start_date DESC",nativeQuery = true)
    public List<CvInfo> findExperiencesByCvID(@Param("id") Integer id); 

    @Query(value = "select ci.* from tb_tr_cv_info ci,tb_m_cv cv,tb_m_education ed where ci.cv_id=:id AND cv.user_id=:id AND ci.edu_id=ed.edu_id ORDER BY ed.start_date DESC",nativeQuery = true)
    public List<CvInfo> findEducationsByCvID(@Param("id") Integer id); 

    @Query(value = "select ci.* from tb_tr_cv_info ci,tb_m_cv cv,tb_m_certification c where ci.cv_id=:id AND cv.user_id=:id AND ci.certification_id=c.certification_id ORDER BY c.issued_date DESC",nativeQuery = true)
    public List<CvInfo> findCertificationByCvID(@Param("id") Integer id); 

    @Query(value = "DELETE FROM tb_tr_cv_info where cv_id=:cvId AND skill_id=:s_id",nativeQuery = true)
    public List<CvInfo> DeleteSkillByCvID(@Param("cvId") Integer cvId,@Param("s_id") Integer s_id); 

    @Query(value = "select * from tb_tr_cv_info where cv_id=:cvId AND skill_id=:s_id",nativeQuery = true)
    public Optional<CvInfo> FindSkillByCvID(@Param("cvId") Integer cvId,@Param("s_id") Integer s_id); 

    @Query(value = "DELETE FROM tb_tr_cv_info where cv_id=:cvId AND exp_id=:expId",nativeQuery = true)
    public List<CvInfo> DeleteExpByCvID(@Param("cvId") Integer cvId,@Param("expId") Integer expId); 

    @Query(value = "select * from tb_tr_cv_info where cv_id=:cvId AND exp_id=:expId",nativeQuery = true)
    public Optional<CvInfo> FindExpByCvID(@Param("cvId") Integer cvId,@Param("expId") Integer expId);
    
    @Query(value = "DELETE FROM tb_tr_cv_info where cv_id=:cvId AND edu_id=:eduId",nativeQuery = true)
    public List<CvInfo> DeleteEduByCvID(@Param("cvId") Integer cvId,@Param("eduId") Integer eduId); 

    @Query(value = "select * from tb_tr_cv_info where cv_id=:cvId AND edu_id=:eduId",nativeQuery = true)
    public Optional<CvInfo> FindEduByCvID(@Param("cvId") Integer cvId,@Param("eduId") Integer eduId);

    @Query(value = "DELETE FROM tb_tr_cv_info where cv_id=:cvId AND certification_id=:certId",nativeQuery = true)
    public List<CvInfo> DeleteCertByCvID(@Param("cvId") Integer cvId,@Param("certId") Integer certId); 

    @Query(value = "select * from tb_tr_cv_info where cv_id=:cvId AND certification_id=:certId",nativeQuery = true)
    public Optional<CvInfo> FindCertByCvID(@Param("cvId") Integer cvId,@Param("certId") Integer certId);
}