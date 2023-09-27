package com.springboot.studentservice.controller;

import com.springboot.studentservice.dto.SubjectDto;
import com.springboot.studentservice.model.SubjectRequestModel;
import com.springboot.studentservice.model.SubjectResponseModel;
import com.springboot.studentservice.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class  SubjectServiceController {

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

    @DeleteMapping("/deleteSubject/{subjectId}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long subjectId){
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content response
    }

    @PutMapping("/updateSubject")
    public ResponseEntity<String> updateSubject(@RequestBody SubjectRequestModel subjectRequestModel){
        ModelMapper modelMapper = new ModelMapper();
        SubjectDto subjectToUpdate = modelMapper.map(subjectRequestModel, SubjectDto.class);
        SubjectDto subjectDto = subjectService.updateSubject(subjectToUpdate);
        return new ResponseEntity<>(subjectDto.getSubject()+" Subject is updated", HttpStatus.OK);
    }

    @PostMapping("/addSubject")
    public ResponseEntity<String> addSubject(@RequestBody SubjectRequestModel subjectRequestModel){
        ModelMapper modelMapper = new ModelMapper();
        SubjectDto subjectToAdd = modelMapper.map(subjectRequestModel, SubjectDto.class);
        SubjectDto subjectDto = subjectService.addSubject(subjectToAdd);
        return new ResponseEntity<>(subjectDto.getSubject()+" Subject is added", HttpStatus.CREATED);
    }
}
