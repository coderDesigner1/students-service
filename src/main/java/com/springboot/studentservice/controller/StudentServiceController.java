package com.springboot.studentservice.controller;

import com.springboot.studentservice.dto.StudentDetailsDto;
import com.springboot.studentservice.entity.Student;
import com.springboot.studentservice.exception.GlobalExceptionHandler;
import com.springboot.studentservice.exception.NotFoundException;
import com.springboot.studentservice.model.StudentRequestModel;
import com.springboot.studentservice.model.StudentResponseModel;
import com.springboot.studentservice.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.springboot.studentservice.shared.Utils;

@RestController
@RequestMapping("/student")
public class StudentServiceController {

    @Autowired
   private StudentService studentService;

    @Autowired
    private Utils utils;

    @GetMapping()
    public ResponseEntity<List<StudentResponseModel>> getAllStudents()  {

        List<StudentDetailsDto> studentsDto = studentService.getAllStudents();


        return new ResponseEntity<>(utils.getStudentResponseModelList(studentsDto), HttpStatus.OK);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Long> addStudent(@RequestBody StudentRequestModel studentDetails){

//        StudentDetailsDto studentDetail = new StudentDetailsDto();
//        ModelMapper modelMapper = new ModelMapper();
//        studentDetail = modelMapper.map(studentDetails, StudentDetailsDto.class);

        StudentDetailsDto S = studentService.addStudent(utils.getStudentDetailsDto(studentDetails));

        return new ResponseEntity<>(S.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody StudentRequestModel student){

        StudentDetailsDto S = studentService.updateStudent(utils.getStudentDetailsDto(student));
        return new ResponseEntity<>("Updated record", HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<StudentResponseModel>> getAllStudentsWithAddress(){
        List<StudentDetailsDto> studentsDto = studentService.getAllStudentsWithAddress();
        //System.out.println("studentsDto = " + studentsDto);
        return new ResponseEntity<>(utils.getStudentResponseModelList(studentsDto), HttpStatus.OK);
    }

    @GetMapping("/getStudent/{email}")
    public ResponseEntity<StudentResponseModel> getStudentByEmail(@PathVariable String email){
        ModelMapper modelMapper = new ModelMapper();
        StudentDetailsDto studentDetailsDto= studentService.getStudentByEmail(email);
        StudentResponseModel studentResponseModel = modelMapper.map(studentDetailsDto, StudentResponseModel.class);
        return new ResponseEntity<>(studentResponseModel, HttpStatus.OK);
    }
    @GetMapping("/getStudentFName/{firstName}")
    public ResponseEntity<List<StudentResponseModel>> getStudentByFirstName(@PathVariable String firstName){
        List<StudentDetailsDto> studentDetailsDtoList= studentService.getStudentByFirstName(firstName);
        return new ResponseEntity<>(utils.getStudentResponseModelList(studentDetailsDtoList), HttpStatus.OK);
    }

    @GetMapping("/getStudentLName/{lastName}")
    public ResponseEntity<List<StudentResponseModel>> getStudentByLastName(@PathVariable String lastName){
        List<StudentDetailsDto> studentDetailsDtoList= studentService.getStudentByLastName(lastName);
        return new ResponseEntity<>(utils.getStudentResponseModelList(studentDetailsDtoList), HttpStatus.OK);
    }

    @GetMapping("/getStudentFLName/{firstName}/{lastName}")
    public ResponseEntity<List<StudentResponseModel>> getStudentByFirstLastName(@PathVariable String firstName, @PathVariable String lastName){
        List<StudentDetailsDto> studentDetailsDtoList= studentService.getStudentByFirstLastName(firstName, lastName);
        return new ResponseEntity<>(utils.getStudentResponseModelList(studentDetailsDtoList), HttpStatus.OK);
    }
}
