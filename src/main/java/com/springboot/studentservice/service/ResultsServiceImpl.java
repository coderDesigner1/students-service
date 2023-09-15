package com.springboot.studentservice.service;

import com.springboot.studentservice.dao.ResultsDao;
import com.springboot.studentservice.dto.ResultsDto;
import com.springboot.studentservice.repository.ResultsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ResultsServiceImpl implements ResultsService{
    @Autowired
    ResultsRepository resultsRepository;

    @Override
    public List<ResultsDto> getAllResults() {
        System.out.println("Testing");
        Iterable<ResultsDao> resultsDao = resultsRepository.getAllResults();
        List<ResultsDto> resultsDtoList = new ArrayList<>();
        System.out.println(StreamSupport.stream(resultsDao.spliterator(), false).count());
    //    ModelMapper modelMapper = new ModelMapper();

        resultsDao.forEach((result)->{
            ResultsDto resultsDto1 = new ResultsDto();
            resultsDto1.setResultId(result.getResultId());
            resultsDto1.setStudentId(result.getStudentId());
            resultsDto1.setFirstName(result.getFirstName());
            resultsDto1.setLastName(result.getLastName());
            resultsDto1.setStreet(result.getStu_add_state());
            resultsDto1.setScore(result.getScore());
            resultsDto1.setSubject(result.getSubject());
            resultsDtoList.add(resultsDto1);
        });
//        System.out.println("resultsDtoList = " + resultsDtoList.toString());
        return resultsDtoList;
    }

    @Override
    public List<ResultsDto> getResultsForStudent(int studentId) {

        return null;
    }
}
