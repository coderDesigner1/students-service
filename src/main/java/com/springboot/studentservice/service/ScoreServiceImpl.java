package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.ScoreDto;
import com.springboot.studentservice.entity.Score;
import com.springboot.studentservice.exception.NotFoundException;
import com.springboot.studentservice.repository.ScoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    public void addScore(ScoreDto scoreDto) {
        ModelMapper modelMapper = new ModelMapper();
        Score score = modelMapper.map(scoreDto, Score.class);
        scoreRepository.save(score);
    }

    @Override
    public void deleteScore(Long scoreId) {
        try{
            scoreRepository.deleteById(scoreId);
        }catch(DataIntegrityViolationException e){
            throw new NotFoundException("Unable to delete Score as it is referenced in Results");
        }


    }

    @Override
    public void updateScore(ScoreDto scoreDto) {
       scoreRepository.updateScore(scoreDto.getScore(), scoreDto.getScoreId());

    }


}
