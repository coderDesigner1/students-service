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
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addScore")
    public ResponseEntity<String> addScore(@RequestBody ScoreRequestModel scoreRequestModel){
        ModelMapper modelMapper = new ModelMapper();
        ScoreDto scoreDto = modelMapper.map(scoreRequestModel, ScoreDto.class);
        scoreService.addScore(scoreDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteScore/{scoreId}")
    public ResponseEntity<String> deleteScore(@PathVariable Long scoreId){
        scoreService.deleteScore(scoreId);
        return new ResponseEntity<>("Score is deleted", HttpStatus.OK);
    }

    @PutMapping("/updateScore")
    public ResponseEntity<String> updateScore(@RequestBody ScoreRequestModel scoreRequestModel){
        ModelMapper modelMapper = new ModelMapper();
        ScoreDto scoreDto = modelMapper.map(scoreRequestModel, ScoreDto.class);
        scoreService.updateScore(scoreDto);
        return new ResponseEntity<>("Score is updated", HttpStatus.OK);
    }
}
