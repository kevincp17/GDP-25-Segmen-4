package com.portal.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Apply;
import com.portal.project.model.CvInfo;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Integer>{
    @Query(value = "SELECT * FROM tb_tr_apply_job a,tb_m_user u,tb_m_cv c where a.user_id=u.user_id and  u.user_id=c.user_id",nativeQuery = true)
    public List<Apply> findAllJobApplies(); 

    @Query(value = "SELECT * FROM tb_tr_apply_job a,tb_m_user u,tb_m_cv c where a.user_id=:id and  a.user_id=u.user_id and  u.user_id=c.user_id",nativeQuery = true)
    public List<Apply> findJobAppliesByUserID(@Param("id") Integer id); 

    @Query(value = "SELECT * FROM tb_tr_apply_job a,tb_m_user u,tb_m_cv c where a.user_id=:uid and a.job_id=:jid and  a.user_id=u.user_id and  u.user_id=c.user_id",nativeQuery = true)
    public List<Apply> findJobAppliesByUserJobID(@Param("uid") Integer uid,@Param("jid") Integer jid); 

    @Query(value = "SELECT status_id,count(status_id) as status_count FROM tb_tr_apply_job group by status_id", nativeQuery = true)
    public List<Apply> getApplyStatusCount();

    @Query(value = "SELECT * FROM tb_tr_apply_job a,tb_m_user u,tb_m_cv c where a.user_id=u.user_id and  u.user_id=c.user_id and a.status_id=5", nativeQuery = true)
    public List<Apply> getApplyByAccepted();
}
