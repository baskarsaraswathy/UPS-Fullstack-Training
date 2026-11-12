// src/main/java/com/example/demo/controller/StudentController.java
package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }
}