// src/main/java/com/example/demo/service/StudentService.java
package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMap;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMap studentMap;

    public StudentDto addStudent(StudentDto studentDto) {
        // 1. Convert incoming DTO to Entity
        Student student = studentMap.toEntity(studentDto);

        // 2. Save Entity to MySQL database
        Student savedStudent = studentRepository.save(student);

        // 3. Convert saved Entity back to DTO and return
        return studentMap.todto(savedStudent);
    }
}