package com.springboot.studentservice.controller;

import com.springboot.studentservice.dto.ResultsDto;
import com.springboot.studentservice.model.ResultsResponseModel;
import com.springboot.studentservice.service.ResultsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultsServiceController {

    @Autowired
    private ResultsService resultsService;
    int i = 0;

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

    @GetMapping("/{studentId}")
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
}
