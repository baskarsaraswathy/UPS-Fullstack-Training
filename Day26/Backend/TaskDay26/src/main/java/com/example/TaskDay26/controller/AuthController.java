package com.example.TaskDay26.controller;

import com.example.TaskDay26.entity.User;
import com.example.TaskDay26.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    // 1. Register User with Duplicate Check
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return "Error: This email is already registered!";
        }
        userRepository.save(user);
        return "User Registered Successfully!";
    }

    // 2. Login User
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            return "Login Successful!";
        }
        return "Invalid Email or Password!";
    }

    // 3. Get / Check Email from DB
    @GetMapping("/get-user/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    // 4. Get All Registered Users for the Table
    @GetMapping("/all-users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}