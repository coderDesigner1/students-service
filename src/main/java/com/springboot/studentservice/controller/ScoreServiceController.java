package com.springboot.studentservice.controller;

import com.springboot.studentservice.dto.ScoreDto;
import com.springboot.studentservice.entity.Score;
import com.springboot.studentservice.model.ScoreRequestModel;
import com.springboot.studentservice.model.ScoreResponseModel;
import com.springboot.studentservice.service.ScoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreServiceController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public ResponseEntity<List<ScoreResponseModel>> getAllScore(){
        List<ScoreDto> score = new ArrayList<>();
        List<ScoreResponseModel> scoreResponseModelList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        score = scoreService.getAllScore();

        score.forEach((s)->{
            ScoreResponseModel  scoreResponseModel = modelMapper.map(s, ScoreResponseModel.class);
            scoreResponseModelList.add(scoreResponseModel);
        });

        return new ResponseEntity<>(scoreResponseModelList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ScoreResponseModel> addScore(ScoreRequestModel scoreRequestModel){
        ScoreResponseModel scoreResponseModel = new ScoreResponseModel();
        scoreResponseModel = scoreService.addScore();
        return scoreRequestModel;
    }
}
