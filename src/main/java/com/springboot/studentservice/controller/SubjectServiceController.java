package com.springboot.studentservice.controller;

import com.springboot.studentservice.dto.SubjectDto;
import com.springboot.studentservice.model.SubjectResponseModel;
import com.springboot.studentservice.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectServiceController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<SubjectResponseModel>> getAllSubjects(){
        List<SubjectDto> subjectDto = new ArrayList<>();
        List<SubjectResponseModel> subjectResponseModelList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        subjectDto = subjectService.getAllSubjects();

        subjectDto.forEach((sub)->{
            SubjectResponseModel subjectResponseModel = modelMapper.map(sub, SubjectResponseModel.class);
            subjectResponseModelList.add(subjectResponseModel);
        });

        return new ResponseEntity<>(subjectResponseModelList, HttpStatus.OK);
    }
}
