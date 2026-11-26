package com.shop.ecommerce.controller;

import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;
import com.shop.ecommerce.dto.*;
import com.shop.ecommerce.model.User;
import com.shop.ecommerce.security.JwtUtil;
import com.shop.ecommerce.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, AuthenticationManager authManager, JwtUtil jwtUtil) {
        this.userService = userService; this.authManager = authManager; this.jwtUtil = jwtUtil;
    }
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest req) {
        User user = userService.register(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(user.getId(), user.getFullName(), user.getEmail()));
    }
    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest req) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(req.email(), req.password()));
        User user = userService.getByEmail(req.email());
        String token = jwtUtil.generateToken(user.getEmail());
        return new LoginResponse(token, user.getId(), user.getFullName(), user.getEmail());
    }
}