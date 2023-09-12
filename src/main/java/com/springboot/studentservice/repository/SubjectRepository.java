package com.springboot.studentservice.repository;

import com.springboot.studentservice.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Modifying
    @Transactional
    @Query(
            value="Delete from Subject where subject=?1",
            nativeQuery = true
    )
    public int deleteSubject(String subject);

    @Modifying
    @Transactional
    @Query(
            value="Update Subject set subject = ?1 where subject= ?2 ",
            nativeQuery = true
    )
    public int updateSubject(String setSubject, String changeSubject);
}
