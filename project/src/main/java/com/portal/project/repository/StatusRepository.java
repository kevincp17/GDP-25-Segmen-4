package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{
    @Query(value = "select status_id from tb_m_status where status_id = ?1", nativeQuery = true)
    public Integer findStatusById(Integer id);
}
