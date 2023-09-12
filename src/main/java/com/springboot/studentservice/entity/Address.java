package com.springboot.studentservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long stu_address_id;

    @Column(name="street", nullable = false)
    private String stu_add_street;

    @Column(name="city", nullable = false)
    private String stu_add_city;

    @Column(name="state", nullable = false)
    private String stu_add_state;

    @Column(name="country", nullable = false)
    private String stu_add_country;

//    @OneToOne(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
//    @JoinColumn(
//            name="student_id", // from database
//            referencedColumnName = "student_id" // from entity
//    )
//    private Student student;


}
