package com.springboot.studentservice.service;

import com.springboot.studentservice.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    public List<SubjectDto> getAllSubjects();

    public void deleteSubject(int subjectId);

    public void updateSubject(SubjectDto subjectDto);

    public void addSubject(SubjectDto subject);
}
