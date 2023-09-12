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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ResultsRepositoryTest {

    @Autowired
    private ResultsRepository resultsRepository;


 /*     @Test
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
    }*/

    @Test
    public void getAllResults(){
        List<ResultsDao> results = resultsRepository.getAllResults();

    }

    // return all subjects with scores for specific student
    @Test
    public void findAllResultsForOneStudent(){
        int studentId = 10;

        List<ResultsProjection> resultsDtoList = resultsRepository.findAllResultsForOneStudent(studentId);
        for (ResultsProjection results : resultsDtoList) {
            System.out.println("First Name: " + results.getFirstName());
            System.out.println("Last Name: " + results.getLastName());
            System.out.println("Subject: " + results.getSubject());
            System.out.println("Score: " + results.getScore());
            System.out.println("-----------------------------------");
        }

    }

    // return one subject score for specific student
    @Test
    public void getSubjectScoreForOneStudent(){
        int studentId = 11;
       String subject = "Maths";

       ResultsProjection result = resultsRepository.getSubjectScoreForOneStudent(studentId, subject);
        System.out.println("First Name: " + result.getFirstName());
        System.out.println("Last Name: " + result.getLastName());
        System.out.println("Subject: " + result.getSubject());
        System.out.println("Score: " + result.getScore());
        System.out.println("-----------------------------------");
    }

    //get all results
    @Test
    public void getAllResultsData(){
        List<ResultsProjection> resultsDtoList = resultsRepository.getAllResultsData();
    }
}
