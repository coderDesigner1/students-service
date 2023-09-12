package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.SubjectDto;
import com.springboot.studentservice.entity.Subject;
import com.springboot.studentservice.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<SubjectDto> getAllSubjects() {

        Iterable<Subject> subject = subjectRepository.findAll();
        List<SubjectDto> subjectDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        subject.forEach((sub)->{
            SubjectDto subjectDto = modelMapper.map(sub, SubjectDto.class);
            subjectDtoList.add(subjectDto);
            System.out.println("subjectDto.getSubjectId() = " + subjectDto.getSubjectId());

        });
        

        return subjectDtoList;
    }
}
