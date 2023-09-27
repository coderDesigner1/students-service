package com.springboot.studentservice.service;

import com.springboot.studentservice.dao.ResultsDao;
import com.springboot.studentservice.dto.ResultsDto;

import java.util.List;

public interface ResultsService {
    public List<ResultsDto> getAllResults();

    public List<ResultsDto> getResultsForStudent(int studentId);

    public ResultsDto getResultsForStudentSubject(int studentId, int subjectId);

    public List<ResultsDto> getResultsForStudentForSubject(int subjectId);

    public int addScoreToStudentForSubject(ResultsDto resultsDto);
}
