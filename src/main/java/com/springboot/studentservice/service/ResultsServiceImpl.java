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
        Iterable<ResultsDao> resultsDao = resultsRepository.findAllResultsForOneStudent(studentId);
        List<ResultsDto> resultsDtoList = new ArrayList<>();
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
        System.out.println("resultsDtoList = " + resultsDtoList.toString());
        return resultsDtoList;


    }

    @Override
    public ResultsDto getResultsForStudentSubject(int studentId, int subjectId) {
        Iterable<ResultsDao> resultsDao = resultsRepository.getSubjectScoreForOneStudent(studentId, subjectId);
        ResultsDto resultsDto = new ResultsDto();
        ResultsDao resultsDao1 = resultsDao.iterator().next();

        resultsDto.setResultId(resultsDao1.getResultId());
        resultsDto.setStudentId(resultsDao1.getStudentId());
        resultsDto.setFirstName(resultsDao1.getFirstName());
        resultsDto.setLastName(resultsDao1.getLastName());
        resultsDto.setStreet(resultsDao1.getStu_add_state());
        resultsDto.setScore(resultsDao1.getScore());
        resultsDto.setSubject(resultsDao1.getSubject());


        System.out.println("resultsDtoList = " + resultsDto.toString());
        return resultsDto;
    }

    @Override
    public List<ResultsDto> getResultsForStudentForSubject(int subjectId) {
        Iterable<ResultsDao> resultsDao = resultsRepository.getStudentScoreForOneSubject(subjectId);
        List<ResultsDto> resultsDtoList = new ArrayList<>();
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
        System.out.println("resultsDtoList = " + resultsDtoList.toString());
        return resultsDtoList;
    }

    @Override
    public int addScoreToStudentForSubject(ResultsDto resultsDto) {
//        ModelMapper modelMapper = new ModelMapper();
//        ResultsDao resultsDao = modelMapper.map(resultsDto, ResultsDao.class);
       int count = resultsRepository.addStudentSubjectScore(resultsDto.getStudentId(), resultsDto.getSubject(), resultsDto.getScore());

       // System.out.println("resultsDtoList = " + resultsDao.toString());
        return count;
    }
}
