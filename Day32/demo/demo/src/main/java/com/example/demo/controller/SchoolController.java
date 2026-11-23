package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.SchoolService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/teachers")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return schoolService.saveTeacher(teacher);
    }

    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
        return schoolService.saveStudent(student);
    }

    @PutMapping("/teachers/{teacherId}/students/{studentId}")
    public Teacher assignStudent(@PathVariable Long teacherId, @PathVariable Long studentId) {
        return schoolService.assignStudentToTeacher(teacherId, studentId);
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return schoolService.getAllTeachers();
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return schoolService.getAllStudents();
    }
}