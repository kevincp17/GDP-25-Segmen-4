package com.portal.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.project.model.QualificationJob;

@Repository
public interface QualificationJobRepository extends JpaRepository<QualificationJob,Integer>{
    @Query(value= "select * from tb_tr_qualification_job where job_id=:id", nativeQuery = true)
    public List<QualificationJob> findQualificationJobsByApplyId(Integer id);
}
