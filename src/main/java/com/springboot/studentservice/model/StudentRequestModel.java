package com.springboot.studentservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.studentservice.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestModel {


    private int id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;
    private String email;
    private Date birthDate;
    private int enterYear;

}
