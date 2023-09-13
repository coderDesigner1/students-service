package com.springboot.studentservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubjectRequestModel {

    @NotBlank(message = "Subject is mandatory")
    @Size(min=2, message = "Subject cannot be less than 2 characters")
    private String subject;
}
