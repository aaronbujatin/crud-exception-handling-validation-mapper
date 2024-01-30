package com.aaronbujatin.jpapractice.service.impl;

import com.aaronbujatin.jpapractice.dto.StudentDto;
import com.aaronbujatin.jpapractice.dto.request.StudentRequest;
import com.aaronbujatin.jpapractice.entity.Student;
import com.aaronbujatin.jpapractice.exception.StudentEmailAlreadyExistException;
import com.aaronbujatin.jpapractice.exception.StudentNotFoundException;
import com.aaronbujatin.jpapractice.mapper.StudentDtoMapper;
import com.aaronbujatin.jpapractice.repository.StudentRepository;
import com.aaronbujatin.jpapractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDtoMapper studentDtoMapper;
    private final StudentRepository studentRepository;

    @Override
    public StudentDto save(StudentRequest studentRequest) {

        var isStudentAlreadyExists = studentRepository.findByEmail(studentRequest.getEmail());
        if(isStudentAlreadyExists != null){
            throw new StudentEmailAlreadyExistException("Email " + studentRequest.getEmail() + " is already exists.");
        }

        Student  student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        studentRepository.save(student);
        StudentDto studentDto = studentDtoMapper.apply(student);

        return studentDto;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id of " + id + " was not found."));

        StudentDto studenDto = studentDtoMapper.apply(student);
        return studenDto;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        return studentRepository.findAll()
                .stream()
                .map(studentDtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(StudentRequest studentRequest, Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id of : " + id + " was not found."));

        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());

        StudentDto studentDto = studentDtoMapper.apply(student);

        return studentDto;
    }


    @Override
    public void deleteStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id of : " + id + " was not found."));

        studentRepository.delete(student);
    }
}
