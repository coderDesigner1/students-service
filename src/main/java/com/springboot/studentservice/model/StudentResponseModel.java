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
public class StudentResponseModel {



    private long studentId;

    @JsonProperty("first-name")
    private String firstName;

    @JsonProperty("last-name")
    private String lastName;

    private String email;

    private Date birthDate;
    private int enterYear;

    @Autowired
    private Address address;


//    private String street;
//
//    public String getStreet(){
//        return address.getStu_add_street();
//    }


}
