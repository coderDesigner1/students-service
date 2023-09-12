package com.springboot.studentservice.repository;

import com.springboot.studentservice.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>{

    @Modifying
    @Transactional
    @Query(
            value="Delete from Score where score_id = ?1",
            nativeQuery = true
    )
    public int deleteScore(int scoreId);

    @Modifying
    @Transactional
    @Query(
            value="Update Score set score = :score where score_id = :Id",
            nativeQuery = true
    )
    public int updateScore(@Param("score") int score, @Param("Id") int scoreId);

    @Modifying
    @Transactional
    @Query(
            value="Insert into Score(score) values ?1",
            nativeQuery = true
    )
    public int addScore(int score);

}
