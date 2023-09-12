package com.springboot.studentservice.repository;

import org.junit.jupiter.api.Test;
import com.springboot.studentservice.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class ScoreRepositoryTest {

    @Autowired
    private ScoreRepository scoreRepository;

    // insert data into score table
    @Test
    public void saveScore(){
       Score score = new Score();

        score.setScore(3);
        scoreRepository.save(score);

    }

    // delete data from score table for an id
    @Test
    public void deleteScoreNativeQuery(){
        int scoreId = 2;

        scoreRepository.deleteScore(scoreId);
    }

    // update score table for an id
    @Test
    public void updateScoreNativeQueryParam(){
        int score = 8;
        int scoreId = 3;

        scoreRepository.updateScore(score, scoreId);
    }

    // get all the scores
    @Test
    public void findAll(){
       List<Score> scoreList = scoreRepository.findAll();

       for(Score s: scoreList) {
           System.out.println(s.getScore());
       }
    }


}
