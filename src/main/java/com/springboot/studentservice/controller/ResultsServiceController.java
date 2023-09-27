package com.springboot.studentservice.controller;

import com.springboot.studentservice.dto.ResultsDto;
import com.springboot.studentservice.dto.StudentDetailsDto;
import com.springboot.studentservice.model.ResultsRequestModel;
import com.springboot.studentservice.model.ResultsResponseModel;
import com.springboot.studentservice.service.ResultsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultsServiceController {

    @Autowired
    private ResultsService resultsService;

    @GetMapping
    public ResponseEntity<List<ResultsResponseModel>> getAllResults(){
        List<ResultsResponseModel> resultsResponseModelList = new ArrayList<>();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<ResultsDto> resultsDto = resultsService.getAllResults();

        resultsDto.forEach((result)->{

             ResultsResponseModel resultsResponseModel = modelMapper.map(result, ResultsResponseModel.class);
            resultsResponseModelList.add(resultsResponseModel);
        });

        return new ResponseEntity<>(resultsResponseModelList, HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ResultsResponseModel>> getResultsForStudent(@PathVariable int studentId){
        ModelMapper modelMapper = new ModelMapper();
        List<ResultsResponseModel> resultsResponseModelList = new ArrayList<>();
        List<ResultsDto> resultsDtoList = resultsService.getResultsForStudent(studentId);
        resultsDtoList.forEach((result)->{
            ResultsResponseModel resultsResponseModel = modelMapper.map(result, ResultsResponseModel.class);
            resultsResponseModelList.add(resultsResponseModel);
        });
        return new ResponseEntity<>(resultsResponseModelList, HttpStatus.OK);
    }

    @GetMapping("/{studentId}/{subjectId}")
    public ResponseEntity<ResultsResponseModel> getResultsForStudentSubject(@PathVariable int studentId, @PathVariable int subjectId){
        ModelMapper modelMapper = new ModelMapper();
        ResultsDto resultsDto = resultsService.getResultsForStudentSubject(studentId, subjectId);
        ResultsResponseModel resultsResponseModel = modelMapper.map(resultsDto, ResultsResponseModel.class);

        return new ResponseEntity<>(resultsResponseModel, HttpStatus.OK);
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<ResultsResponseModel>> getResultsForStudentForSubject(@PathVariable int subjectId){
        ModelMapper modelMapper = new ModelMapper();
        List<ResultsResponseModel> resultsResponseModelList = new ArrayList<>();
        List<ResultsDto> resultsDtoList = resultsService.getResultsForStudentForSubject(subjectId);
        resultsDtoList.forEach((result)->{
            ResultsResponseModel resultsResponseModel = modelMapper.map(result, ResultsResponseModel.class);
            resultsResponseModelList.add(resultsResponseModel);
        });
        return new ResponseEntity<>(resultsResponseModelList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addScoreToStudentForSubject(@RequestBody ResultsRequestModel resultsRequestModel ){
            ModelMapper modelMapper = new ModelMapper();
            ResultsDto resultsDto = modelMapper.map(resultsRequestModel, ResultsDto.class);
            int count =  resultsService.addScoreToStudentForSubject(resultsDto);
            if(count > 0){
                return new ResponseEntity<>("Student Result Added", HttpStatus.CREATED);
            }
        return new ResponseEntity<>("Student not found", HttpStatus.OK);
    }
}
