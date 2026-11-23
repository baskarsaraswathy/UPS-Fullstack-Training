package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "st_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must contain 3 to 50 characters")
    private String name;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20, message = "Password must contain 8 to 20 characters")
    private String password;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore // Prevents infinite recursion loops when converting to JSON
    private List<Teacher> teachers = new ArrayList<>();

    public Student() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Teacher> getTeachers() { return teachers; }
    public void setTeachers(List<Teacher> teachers) { this.teachers = teachers; }
}