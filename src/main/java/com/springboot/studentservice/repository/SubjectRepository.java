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
            value="Delete from Subject where subject_Id=?1",
            nativeQuery = true
    )
    public void deleteSubject(int id);

    @Modifying
    @Transactional
    @Query(
            value="Update Subject set subject = ?1 where subject_id= ?2 ",
            nativeQuery = true
    )
    public void updateSubject(String setSubject, int id);
//
//    @Modifying
//    @Transactional
//    @Query(
//            value="Insert into Subject(subject) values (?1)",
//            nativeQuery = true
//    )
//
//    public void addSubject(String subject);
}
