package com.springboot.studentservice.repository;

import com.springboot.studentservice.dao.ResultsDao;
import com.springboot.studentservice.dto.ResultsDto;
import com.springboot.studentservice.interfaces.ResultsProjection;
import com.springboot.studentservice.entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {
//    @Query("SELECT new com.springboot.studentservice.dao.ResultsDao(firstName, lastName) FROM Student")
//    @Query("SELECT new com.springboot.studentservice.dao.ResultsDao(firstName, lastName, subject) FROM Student s, Subject su where r.student_id = s.student_id and r.subject_id = su.subject_id")
//      @Query("SELECT new com.springboot.studentservice.dao.ResultsDao(s.firstName, s.lastName, a.stu_add_state) FROM Student s JOIN s.address a ")
      @Query("SELECT new com.springboot.studentservice.dao.ResultsDao(s.firstName, s.lastName, s.studentId,r.resultId, su.subject, sc.score) FROM Results r JOIN r.student s JOIN r.subject su JOIN r.score sc ")
  //  SELECT u, p FROM Player p RIGHT JOIN p.owner u WHERE ...

    public List<ResultsDao> getAllResults();

//    @Query(value = "SELECT new "
//            + "com.rahul.employeeportal.model.ActiveSession(s.username, e.firstName, e.lastName, MAX(s.loginTime), s.logoutTime, s.isActive) from SessionsStore s, Employee e "
//            + " where e.username = s.username GROUP BY s.username")
//    List<ActiveSession> findUsers();

    @Query(
            value="select first_name as firstName, last_name as lastName, subject, score from results r,student st, subject su, score sc\n" +
                    "where r.student_id = st.student_id\n" +
                    "and r.subject_id = su.subject_id\n" +
                    "and r.score_id = sc.score_id\n" +
                    "and r.student_id = ?1",
            nativeQuery = true
    )
    public List<ResultsProjection> findAllResultsForOneStudent(int studentId);

    //return one subject with scores for specific student
    @Query(
           value = "select first_name as firstName, last_name as lastName, subject, score from results r,student st, subject su, score sc\n" +
                   "where r.student_id = st.student_id\n" +
                   "and r.subject_id = su.subject_id\n" +
                   "and r.score_id = sc.score_id\n" +
                   "and r.student_id = ?1 and subject = ?2" ,
            nativeQuery = true
    )
    public ResultsProjection getSubjectScoreForOneStudent(int id, String subject);

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

}
