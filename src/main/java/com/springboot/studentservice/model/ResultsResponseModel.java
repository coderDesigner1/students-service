package com.springboot.studentservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultsResponseModel {
    private long resultId;
    private int studentId;
    private String firstName;
    private String lastName;
    private int score;
    private String subject;
}
