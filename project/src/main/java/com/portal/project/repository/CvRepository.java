package com.portal.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portal.project.model.Cv;

@Repository
public interface CvRepository extends JpaRepository<Cv,Integer>{
    // @Query(value = "select*from tb_m_cv cv,tb_m_user u where cv.user_id=:id",nativeQuery = true)
    // public List<Cv> findCvByUserId(@Param("id") Integer id);

    @Query(value="select *\n"+
    "from tb_m_cv cv JOIN tb_m_user u ON cv.user_id=u.user_id where cv.user_id=:id",nativeQuery = true)
    public Cv findCVByUserId(@Param("id") Integer id);

    @Query(value = "select name from tb_m_cv where cv_id = ?1", nativeQuery = true)
    public String findNameById(Integer id);
}
