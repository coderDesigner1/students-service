package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    public List<SubjectDto> getAllSubjects();

    public void deleteSubject(Long subjectId);

    public SubjectDto updateSubject(SubjectDto subjectDto);

    public SubjectDto addSubject(SubjectDto subject);
}
