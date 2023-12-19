package com.portal.project.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Apply;
import com.portal.project.model.InterviewUser;

@Repository
public interface InterviewUserRepository extends JpaRepository<InterviewUser, Integer>{
    @Query(value = "select LEFT(interview_date,11) from tb_tr_interview_user where interview_user_id = ?1", nativeQuery = true)
    public String findInterviewDateById(Integer id);

    @Query(value = "select LEFT(RIGHT(interview_date,8),5) from tb_tr_interview_user where interview_user_id = ?1", nativeQuery = true)
    public String findInterviewTimeById(Integer id);

    @Query(value = "select link from tb_tr_interview_user where interview_user_id = ?1", nativeQuery = true)
    public String findLinkById(Integer id);

    @Query(value = "SELECT * FROM tb_tr_interview_user where applicant_id= ?1",nativeQuery = true)
    public List<InterviewUser> findApplicantByUserID(Integer id);
    
    @Query(value = "SELECT * FROM tb_tr_interview_user where trainer_id= ?1",nativeQuery = true)
    public List<InterviewUser> findTrainerByUserID(Integer id);

    @Query(value = "SELECT * FROM tb_tr_interview_user iu,tb_m_user u where iu.ta_id=u.user_id",nativeQuery = true)
    public List<InterviewUser> findInterviewUserByTA();

    @Query(value = "SELECT * FROM tb_tr_interview_user iu,tb_m_user u where iu.trainer_id=u.user_id",nativeQuery = true)
    public List<InterviewUser> findInterviewUserByTrainer();

    @Query(value = "SELECT a.job_id,AVG(s.score) as average_score FROM tb_tr_interview_user iu,tb_tr_apply_job a,tb_tr_score s where iu.apply_id=a.apply_id and iu.interview_user_id=s.interview_user_id and a.status_id=5 GROUP BY a.job_id",nativeQuery = true)
    public List<Object> findAverageScore();
}
