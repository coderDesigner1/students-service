package com.springboot.studentservice.shared;

import com.springboot.studentservice.dto.StudentDetailsDto;
import com.springboot.studentservice.entity.Student;
import com.springboot.studentservice.model.StudentRequestModel;
import com.springboot.studentservice.model.StudentResponseModel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class Utils {
    // mapping student to studentDetailsDto
    // Entity to DTO
    public List<StudentDetailsDto> getStudentDetailsList(Iterable<Student> students){
        List<StudentDetailsDto> studentList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        students.forEach((student) -> {
            StudentDetailsDto studentDetailsDto = modelMapper.map(student, StudentDetailsDto.class);
            studentList.add(studentDetailsDto);
        });
       // System.out.println("studentList = " + studentList);
        return studentList;
    }

    // mapping studentDetailsDto to studentResponseModel
    // DTO to ResponseModel
    public List<StudentResponseModel> getStudentResponseModelList(List<StudentDetailsDto> students){
        List<StudentResponseModel> studentList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.createTypeMap(StudentDetailsDto.class, StudentResponseModel.class)
                .addMapping(StudentDetailsDto::getId, StudentResponseModel::setStudentId);

        students.forEach((studentDetailsDto) -> {
            System.out.println("studentDetailsDto = " + studentDetailsDto);

            StudentResponseModel studentResponseModel = modelMapper.map(studentDetailsDto, StudentResponseModel.class);
            studentList.add(studentResponseModel);
        });
        System.out.println("studentList = " + studentList);
        return studentList;
    }

    // map studentRequestModel to studentDetailsDto
    public StudentDetailsDto getStudentDetailsDto(StudentRequestModel student){
        StudentDetailsDto studentDetail = new StudentDetailsDto();
        ModelMapper modelMapper = new ModelMapper();
        studentDetail.setId(student.getId());
        studentDetail = modelMapper.map(student, StudentDetailsDto.class);
        return studentDetail;
    }
}
