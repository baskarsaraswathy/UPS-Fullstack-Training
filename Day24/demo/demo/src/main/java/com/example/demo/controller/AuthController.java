package com.example.demo.controller;

import com.example.demo.dto.SignupDTO;
import com.example.demo.entity.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/users")
    public ResponseEntity<?> register(@RequestBody User user) {
        // Validate if email already exists to prevent 500 error
        if (authService.emailExists(user.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already registered!");
        }

        User savedUser = authService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<String> login(@RequestBody SignupDTO loginData) {
        String response = authService.verifyLogin(loginData);

        if (response.startsWith("Error")) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }
}