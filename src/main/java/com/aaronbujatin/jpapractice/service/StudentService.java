package com.aaronbujatin.jpapractice.service;

import com.aaronbujatin.jpapractice.dto.StudentDto;
import com.aaronbujatin.jpapractice.dto.request.StudentRequest;

import java.util.List;

public interface StudentService {

    StudentDto save(StudentRequest studentRequest);

    StudentDto getStudentById(Long id);

    List<StudentDto> getAllStudent();

    StudentDto updateStudent(StudentRequest studentRequest, Long id);

    void deleteStudentById(Long id);

}
