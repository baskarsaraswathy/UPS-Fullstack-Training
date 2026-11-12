package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMap {

    // Converts Entity to DTO
    StudentDto todto(Student student);

    // Converts DTO to Entity
    Student toEntity(StudentDto studentDto);
}