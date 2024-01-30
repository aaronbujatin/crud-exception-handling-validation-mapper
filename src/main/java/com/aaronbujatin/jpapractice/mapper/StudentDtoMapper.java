package com.aaronbujatin.jpapractice.mapper;

import com.aaronbujatin.jpapractice.dto.StudentDto;
import com.aaronbujatin.jpapractice.entity.Student;
import com.aaronbujatin.jpapractice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class StudentDtoMapper implements Function<Student, StudentDto> {

    private final StudentRepository studentRepository;

    @Override
    public StudentDto apply(Student student) {
        return new StudentDto(
                student.getFirstName(),
                student.getFirstName(),
                student.getEmail());
    }
}
