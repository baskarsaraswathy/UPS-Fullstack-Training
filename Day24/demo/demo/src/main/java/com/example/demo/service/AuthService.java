package com.example.demo.service;

import com.example.demo.dto.SignupDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // Checks if the email is already in the database
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    // Handles POST /users (Registration)
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Handles POST /api/auth/login (Authentication)
    public String verifyLogin(SignupDTO loginData) {
        User existingUser = userRepository.findByEmail(loginData.getEmail());

        if (existingUser == null) {
            return "Error: Email not found";
        }

        if (!existingUser.getPassword().equals(loginData.getPassword())) {
            return "Error: Incorrect password";
        }

        return "SignUp Successful";
    }
}