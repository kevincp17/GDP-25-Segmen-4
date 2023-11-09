package com.portal.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Apply;
import com.portal.project.model.Cv;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Integer> {
    // @Query(value = "select * from tb_tr_job_vacancy v, tb_m_cv c, tb_tr_apply_job a, tb_m_user u where a.job_id = v.job_id and a.user_id = u.user_id and u.user_id = c.cv_id", nativeQuery = true)
    //     public List<Apply> findApplication();
}