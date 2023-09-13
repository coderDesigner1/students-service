package com.springboot.studentservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubjectRequestModel {
    private int subjectId;
    private String subject;
}
