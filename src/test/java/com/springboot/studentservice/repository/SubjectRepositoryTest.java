package com.springboot.studentservice.repository;

import com.springboot.studentservice.entity.Score;
import com.springboot.studentservice.entity.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;


@SpringBootTest
class SubjectRepositoryTest {

    @Autowired
    private SubjectRepository subjectRepository;

    // insert subject into table
    @Test
    public void saveSubject() {
        Subject subject = new Subject();

        subject.setSubject("Science");

        subjectRepository.save(subject);

    }

    // delete subject from the table if there is no relation with other tables
    @Test
    public void deleteSubject(){
       String subject = "Math";

        subjectRepository.deleteSubject(subject);
    }

    // update subject name in the table if there is no relation with other tables
    @Test
    public void updateSubject(){
        String changeSubject = "Chemistry";
        String forSubject = "Science";

        subjectRepository.updateSubject(changeSubject, forSubject);
    }

    // get all the subjects
    @Test
    public void findAll(){
        List<Subject> subjectList = subjectRepository.findAll();

        for(Subject s: subjectList) {
            System.out.println(s.getSubject());
        }
    }


}