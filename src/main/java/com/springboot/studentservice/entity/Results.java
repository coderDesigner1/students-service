package com.springboot.studentservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Results {
    @Id
    @Column(nullable = false)

    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long resultId;

   @ManyToOne
   @JoinColumn(name="student_id")
   private Student student;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name="score_id")
    private Score score;
}
