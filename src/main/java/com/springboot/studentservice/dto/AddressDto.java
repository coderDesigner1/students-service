package com.springboot.studentservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDto {
    private int stu_address_id;
    private String stu_add_street;
    private String stu_add_city;
    private String stu_add_state;
    private String stu_add_country;

}
