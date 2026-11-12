package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Entity.Student;
import com.example.StudentManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService serv;

    @PostMapping("/san")
    public Student addStudent(@RequestBody Student s) {
        return serv.addStudent(s);
    }
}