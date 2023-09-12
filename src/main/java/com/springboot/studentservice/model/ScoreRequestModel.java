package com.springboot.studentservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScoreRequestModel {
    private int scoreId;
    private int score;
}
