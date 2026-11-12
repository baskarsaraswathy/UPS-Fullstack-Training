package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-11-12T14:37:14+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class StudentMapImpl implements StudentMap {

    @Override
    public StudentDto todto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId( student.getId() );
        studentDto.setName( student.getName() );
        studentDto.setEmail( student.getEmail() );

        return studentDto;
    }

    @Override
    public Student toEntity(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentDto.getId() );
        student.setName( studentDto.getName() );
        student.setEmail( studentDto.getEmail() );

        return student;
    }
}
