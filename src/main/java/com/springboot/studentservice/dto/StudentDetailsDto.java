package com.springboot.studentservice.dto;

import com.springboot.studentservice.entity.Address;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDetailsDto {

    @Autowired
    private Address address;

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private int enterYear;

}
