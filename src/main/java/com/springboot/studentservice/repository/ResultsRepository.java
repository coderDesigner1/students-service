package com.springboot.studentservice.repository;

import com.springboot.studentservice.dao.ResultsDao;
import com.springboot.studentservice.dto.ResultsDto;
import com.springboot.studentservice.interfaces.ResultsProjection;
import com.springboot.studentservice.entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {
//    @Query("SELECT new com.springboot.studentservice.dao.ResultsDao(firstName, lastName) FROM Student")
//    @Query("SELECT new com.springboot.studentservice.dao.ResultsDao(firstName, lastName, subject) FROM Student s, Subject su where r.student_id = s.student_id and r.subject_id = su.subject_id")
//      @Query("SELECT new com.springboot.studentservice.dao.ResultsDao(s.firstName, s.lastName, a.stu_add_state) FROM Student s JOIN s.address a ")
      @Query("SELECT new com.springboot.studentservice.dao.ResultsDao(s.firstName, s.lastName, s.studentId,r.resultId, su.subject, sc.score) FROM Results r JOIN r.student s JOIN r.subject su JOIN r.score sc ")
  //  SELECT u, p FROM Player p RIGHT JOIN p.owner u WHERE ...

    public List<ResultsDao> getAllResults();


    @Query( "SELECT new com.springboot.studentservice.dao.ResultsDao(s.firstName, s.lastName, s.studentId,r.resultId, su.subject, sc.score) FROM Results r JOIN r.student s JOIN r.subject su JOIN r.score sc WHERE s.studentId=?1")

    public List<ResultsDao> findAllResultsForOneStudent(int studentId);

    //return one subject with scores for specific student
    @Query("SELECT new com.springboot.studentservice.dao.ResultsDao(s.firstName, s.lastName, s.studentId,r.resultId, su.subject, sc.score) " +
            "FROM Results r JOIN r.student s JOIN r.subject su JOIN r.score sc WHERE s.studentId=?1 and su.subject_id=?2")

    public List<ResultsDao> getSubjectScoreForOneStudent(int studentId, int subjectId);

    //return all students scores for one subject
    @Query("SELECT new com.springboot.studentservice.dao.ResultsDao(s.firstName, s.lastName, s.studentId,r.resultId, su.subject, sc.score) " +
            "FROM Results r JOIN r.student s JOIN r.subject su JOIN r.score sc WHERE su.subject_id=?1")

    public List<ResultsDao> getStudentScoreForOneSubject(int subjectId);



    //return all subjects/scores/addresses/students
    @Query(
            value = "select first_name as firstName, last_name as lastName, subject, score from results r,student st, subject su, score sc\n" +
                    "where r.student_id = st.student_id\n" +
                    "and r.subject_id = su.subject_id\n" +
                    "and r.score_id = sc.score_id\n" +
                    "order by r.student_id, r.subject_id" ,
            nativeQuery = true
    )
    public List<ResultsProjection> getAllResultsData();


    // insert subject score to a student
    @Modifying
    @Transactional
//    @Query("INSERT INTO new com.springboot.studentservice.dao.ResultsDao(studentId, subjectId, scoreId) " +
//            "SELECT s.studentId, su.subjectId, sc.scoreId FROM Student s JOIN Subject su JOIN Score sc WHERE s.studentId = ?1 and su.subject = ?2 " +
//            "and sc.score = ?3)" )

    @Query(value = "INSERT INTO Results (student_id, subject_id, score_id) " +
            "VALUES (?1,?2,?3)", nativeQuery = true)
    public int addStudentSubjectScore(Long studentId, Long subject_id, Long score_id);

}
