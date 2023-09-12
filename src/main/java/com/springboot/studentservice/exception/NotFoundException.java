package com.springboot.studentservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}
