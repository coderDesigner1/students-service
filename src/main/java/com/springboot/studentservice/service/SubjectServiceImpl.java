package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.SubjectDto;
import com.springboot.studentservice.entity.Subject;
import com.springboot.studentservice.exception.NotFoundException;
import com.springboot.studentservice.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        });
        

        return subjectDtoList;
    }

    @Override
    public void deleteSubject(Long subjectId) {

        try{subjectRepository.deleteById(subjectId);}
        catch(DataIntegrityViolationException e){
            throw new NotFoundException("Unable to delete Subject");
        };
    }

    @Override
    public SubjectDto updateSubject(SubjectDto subjectDto) {

        ModelMapper modelMapper = new ModelMapper();
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        Subject subject1 = subjectRepository.save(subject);
        return modelMapper.map(subject1, SubjectDto.class);
    }

    @Override
    public SubjectDto addSubject(SubjectDto subjectDto) {
        ModelMapper modelMapper = new ModelMapper();
        Subject subject = subjectRepository.save(modelMapper.map(subjectDto, Subject.class));
        return modelMapper.map(subject, SubjectDto.class);
    }
}
