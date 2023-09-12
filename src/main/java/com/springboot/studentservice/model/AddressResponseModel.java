package com.springboot.studentservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressResponseModel{
    private int stu_address_id;
    private String stu_add_street;
    private String stu_add_city;
    private String stu_add_state;
    private String stu_add_country;

}
