package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.ScoreDto;
import com.springboot.studentservice.entity.Score;
import com.springboot.studentservice.repository.ScoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public List<ScoreDto> getAllScore() {
        Iterable<Score> score = scoreRepository.findAll();
        List<ScoreDto> scoreDetails = new ArrayList<>();
        ModelMapper scoreMap = new ModelMapper();
        score.forEach((s)->{
            ScoreDto scoreDto = scoreMap.map(s, ScoreDto.class);
            scoreDetails.add(scoreDto);
        });
        return scoreDetails;
    }

    @Override
    public ScoreDto addScore() {
        return null;
    }


}
