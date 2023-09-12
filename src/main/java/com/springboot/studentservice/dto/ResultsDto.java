package com.springboot.studentservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultsDto {
    private long resultId;
    private long studentId;
    private String firstName;
    private String lastName;
    private int score;
    private String subject;
    private String street;

//    public ResultsDto(Long resultId, String firstName, String lastName, String subject, Integer score) {
//        this.resultId = resultId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.subject = subject;
//        this.score = score;
//    }
}
