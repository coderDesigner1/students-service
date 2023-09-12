package com.springboot.studentservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(
                name="score_unique",
                columnNames = "score"
        )
)
public class Score {

    @Id
    @Column(
            name = "score_id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int scoreId;

    @Column(nullable = false)
    private int score;

   @OneToMany(mappedBy = "score")
    private List<Results> results = new ArrayList<>();

}