package com.example.TeachersManagement.controller;

import com.example.TeachersManagement.entity.Teacher;
import com.example.TeachersManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService serv;

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher t)
    {
        return serv.addTeacher(t);
    }

    @GetMapping
    public List<Teacher> getTeacher()
    {
        return serv.getTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Long id){
        return serv.getTeacher(id);
    }

    @PutMapping("/{id}")
    public Teacher UpdateTeacher(@PathVariable Long id,@RequestBody Teacher t)
    {
        return serv.UpdateTeacher(id,t);
    }

    @PatchMapping("/{id}")
    public Teacher UpdatTeacher(@PathVariable Long id,@RequestBody Teacher t)
    {
        return serv.UpdatTeacher(id,t);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id)
    {
        return serv.deleteTeacher(id);
    }
}