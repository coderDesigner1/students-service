package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.ResultsDto;

import java.util.List;

public interface ResultsService {
    public List<ResultsDto> getAllResults();

    public List<ResultsDto> getResultsForStudent(int studentId);
}
