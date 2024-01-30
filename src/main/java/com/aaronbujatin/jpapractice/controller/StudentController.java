package com.aaronbujatin.jpapractice.controller;


import com.aaronbujatin.jpapractice.dto.StudentDto;
import com.aaronbujatin.jpapractice.dto.request.StudentRequest;
import com.aaronbujatin.jpapractice.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> registerStudent(@Valid @RequestBody StudentRequest studentRequest){
        StudentDto response = studentService.save(studentRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        StudentDto response = studentService.getStudentById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        List<StudentDto> response = studentService.getAllStudent();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequest studentRequest){
        StudentDto response = studentService.updateStudent(studentRequest,id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        String response = "Student with id of " + id +  " was successfully deleted.";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
