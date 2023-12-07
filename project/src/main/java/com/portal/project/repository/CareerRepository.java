package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career,Integer>{
    @Query(value = "select title from tb_tr_job_vacancy where job_id = ?1", nativeQuery = true)
    public String findJobById(Integer id);
}