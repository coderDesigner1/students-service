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
                name="subject_unique",
                columnNames = "subject"
        )
)
public class Subject {

    @Id
    @Column(name = "subject_id")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int subject_id;

    @Column(nullable = false)
    private String subject;

//    @OneToMany(mappedBy = "subject")
//    private List<Results> results = new ArrayList<>();
}


