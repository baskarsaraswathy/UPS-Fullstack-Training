package com.example.TeachersManagement.service;

import com.example.TeachersManagement.entity.Teacher;
import com.example.TeachersManagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repo;

    public Teacher addTeacher(Teacher t){
        return repo.save(t);
    }

    public List<Teacher> getTeachers()
    {
        return repo.findAll();
    }

    public Teacher getTeacher(Long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Cannot find Teacher"));
    }

    public String deleteTeacher(Long id){
        repo.deleteById(id);
        return "Teacher Deleted Successfully";
    }

    public Teacher UpdateTeacher(Long id,Teacher t){
        Teacher ta=repo.findById(id).orElse(null);
        if(ta==null)
        {
            return null;
        }
        if(t.getName()!=null){
            ta.setName(t.getName());}
        if(t.getSubject()!=null){
            ta.setSubject(t.getSubject());}
        return repo.save(ta);
    }

    public Teacher UpdatTeacher(Long id,Teacher t){
        Teacher ta=repo.findById(id).orElse(null);
        if(ta==null) {
            return null;
        }
        return repo.save(ta);
    }
}