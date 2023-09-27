package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.ScoreDto;
import com.springboot.studentservice.entity.Score;
import com.springboot.studentservice.model.ScoreResponseModel;

import java.util.List;

public interface ScoreService {
    public List<ScoreDto> getAllScore();

    public void addScore(ScoreDto scoreDto);

    public void deleteScore(Long scoreId);

    public void updateScore(ScoreDto scoreDto);
}
