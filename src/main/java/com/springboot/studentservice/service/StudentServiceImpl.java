package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.StudentDetailsDto;
import com.springboot.studentservice.entity.Student;
import com.springboot.studentservice.exception.NotFoundException;
import com.springboot.studentservice.model.StudentRequestModel;
import com.springboot.studentservice.model.StudentResponseModel;
import com.springboot.studentservice.repository.StudentRepository;
import com.springboot.studentservice.shared.Utils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Utils utils;

    public List<StudentDetailsDto> getAllStudents() {
        Iterable<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
        return utils.getStudentDetailsList(studentList);
    }

    @Override
    public StudentDetailsDto addStudent(StudentDetailsDto student) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Student s = modelMapper.map(student, Student.class);
        studentRepository.save(s);
        modelMapper.createTypeMap(Student.class, StudentDetailsDto.class)
                .addMapping(Student::getStudentId, StudentDetailsDto::setId);
        return modelMapper.map(s, StudentDetailsDto.class);
    }

   @Override
    public StudentDetailsDto updateStudent(StudentDetailsDto studentDetailsDto) {
       /*int count = studentRepository.updateStudentById(
                studentDetailsDto.getFirstName(),
                studentDetailsDto.getLastName(),
                studentDetailsDto.getEmail(),
                studentDetailsDto.getBirthDate(),
                studentDetailsDto.getEnterYear(),
                studentDetailsDto.getId()
        );*/
       ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
       modelMapper.createTypeMap(StudentDetailsDto.class, Student.class)
               .addMapping(StudentDetailsDto::getId,Student::setStudentId );
        Student s = modelMapper.map(studentDetailsDto, Student.class);
        studentRepository.save(s);

        return modelMapper.map(s, StudentDetailsDto.class);
    }

   @Override
    public void deleteStudent(Long id) {
        try{
            studentRepository.deleteById(id);

        }catch(DataIntegrityViolationException e){
           throw new NotFoundException("Student cannot be deleted");
        }
    }

    @Override
    public List<StudentDetailsDto> getAllStudentsWithAddress() {
        Iterable<Student> studentsWithAddresses = studentRepository.findAllStudentsWithAddress();
       // ModelMapper modelMapper = new ModelMapper();
        return utils.getStudentDetailsList(studentsWithAddresses);

    }

    @Override
    public StudentDetailsDto getStudentByEmail(String email) {
        ModelMapper modelMapper = new ModelMapper();
        Student sDetails = studentRepository.findStudentByEmail(email);
        return modelMapper.map(sDetails, StudentDetailsDto.class);
    }

    @Override
    public List<StudentDetailsDto> getStudentByFirstName(String firstName) {

        Iterable<Student> sDetails = studentRepository.findStudentByFirstName(firstName);
        return utils.getStudentDetailsList(sDetails);
    }

    @Override
    public List<StudentDetailsDto> getStudentByLastName(String lastName) {
        Iterable<Student> sDetails = studentRepository.findStudentByLastName(lastName);
        return utils.getStudentDetailsList(sDetails);
    }

    @Override
    public List<StudentDetailsDto> getStudentByFirstLastName(String firstName, String lastName) {
        Iterable<Student> sDetails = studentRepository.findStudentWithSameFirstAndLastName(firstName,lastName);
        return utils.getStudentDetailsList(sDetails);
    }


}
