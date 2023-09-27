package com.springboot.studentservice.repository;


import com.springboot.studentservice.dao.ResultsDao;
import com.springboot.studentservice.interfaces.ResultsProjection;
import com.springboot.studentservice.entity.Results;
import com.springboot.studentservice.entity.Score;
import com.springboot.studentservice.entity.Student;
import com.springboot.studentservice.entity.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ResultsRepositoryTest {

    @Autowired
    private ResultsRepository resultsRepository;


/*    @Test
  public void getAllResults() throws Exception{
        Student student = new Student();
            student.setLastName("Carfagna");
            student.setFirstName("Joaquin");
            student.setEmail("jcarfagna@yahoo.com");
            student.setEnterYear(2018);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDate = dateFormat.parse("2018-06-29");
            student.setBirthDate(birthDate);

        Subject subject = new Subject();
            subject.setSubject("Social Sciences");

        Score score = new Score();
            score.setScore(11);

        Results results = Results.builder()
                .student(student)
                .score(score)
                .subject(subject)
                .build();

        resultsRepository.save(results);
    }
*/
      @Test
        public void getAllResults(){
            List<ResultsDao> results = resultsRepository.getAllResults();
            assertNotNull(results, "Results should not be null");
            assertEquals(96, results.size(), "There should be 96 results");
            for(ResultsDao result: results){
                assertNotNull(result.getResultId(),"Result Id should not be null");
            }
        }

    // return all subjects with scores for specific student
    @Test
    public void findAllResultsForOneStudent(){
        int studentId = 2;

        List<ResultsDao> resultsDaoList = resultsRepository.findAllResultsForOneStudent(studentId);
        assertNotNull(resultsDaoList, "Results should not be null");
        assertEquals(4, resultsDaoList.size(), "There should be 4 results");

    }

    // return one subject score for specific student
    @Test
    public void getSubjectScoreForOneStudent(){
        int studentId = 11;
       int subjectId = 3;

       List<ResultsDao> result = resultsRepository.getSubjectScoreForOneStudent(studentId, subjectId);
        assertNotNull(result, "Results should not be null");
        assertEquals(1, result.size(), "There should be 1 result");
    }

    // return one subject score for specific student
    @Test
    public void getStudentScoreForOneSubject(){
        int subjectId = 3;

        List<ResultsDao> result = resultsRepository.getStudentScoreForOneSubject(subjectId);
        assertNotNull(result, "Results should not be null");
        assertEquals(24, result.size(), "There should be 24 result");
    }

    @Test
    public void addStudentSubjectScore(){
          String subject = "Maths";
          long studentId = 4;
          int score = 5;
          int count = resultsRepository.addStudentSubjectScore(studentId, subject, score);

//          assertEquals(1, count, "Result inserted");
          assertEquals(0, count, "Student/Subject not found");

    }

    //get all results
    @Test
    public void getAllResultsData(){
        List<ResultsProjection> resultsDtoList = resultsRepository.getAllResultsData();
    }
}
