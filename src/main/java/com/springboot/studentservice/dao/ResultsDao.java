package com.springboot.studentservice.dao;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultsDao {
    private Long resultId;
    private Long studentId;
    private String firstName;
    private String lastName;
    private String subject;
    private String stu_add_state;
    private int score;
    private int scoreId;
    private int subjectId;

    public ResultsDao(String firstName, String lastName, Long studentId, Long resultId, String subject, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.resultId = resultId;
        this.studentId = studentId;
        this.subject = subject;
        this.score = score;
//        this.subjectId = subjectId;
//        this.scoreId = scoreId;
    }
}
