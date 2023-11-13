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
    @Query(value = "SELECT * FROM tb_tr_apply_job where user_id=:id",nativeQuery = true)
    public List<Apply> findJobAppliesByUserID(@Param("id") Integer id); 
}