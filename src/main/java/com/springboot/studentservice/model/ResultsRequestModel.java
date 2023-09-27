package com.springboot.studentservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultsRequestModel {
    private int studentId;
    private int score;
    private String subject;
}
