package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.StudentDetailsDto;
import com.springboot.studentservice.model.StudentRequestModel;
import com.springboot.studentservice.model.StudentResponseModel;


import java.util.List;


public interface StudentService {
    public List<StudentDetailsDto> getAllStudents();

    public StudentDetailsDto addStudent(StudentDetailsDto student);

    public StudentDetailsDto updateStudent(StudentDetailsDto studentDetailsDto);

    public boolean deleteStudent(int id);

    public List<StudentDetailsDto> getAllStudentsWithAddress();

    public StudentDetailsDto getStudentByEmail(String email);

    public List<StudentDetailsDto> getStudentByFirstName(String firstName);

    public List<StudentDetailsDto> getStudentByLastName(String lastName);

    public List<StudentDetailsDto> getStudentByFirstLastName(String firstName, String lastName);
}
