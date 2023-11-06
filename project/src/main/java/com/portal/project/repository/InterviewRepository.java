package com.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.project.model.InterviewUser;

@Repository
public interface InterviewRepository extends JpaRepository<InterviewUser, Integer>{

}
