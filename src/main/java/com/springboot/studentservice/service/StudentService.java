package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.StudentDetailsDto;
import com.springboot.studentservice.model.StudentRequestModel;


import java.util.List;


public interface StudentService {
    public List<StudentDetailsDto> getAllStudents();

    public StudentDetailsDto addStudent(StudentDetailsDto student);

    public StudentDetailsDto updateStudent(StudentDetailsDto studentDetailsDto);

    public boolean deleteStudent(int id);
}
