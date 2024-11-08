package com.abhishek.ems.controller;

import com.abhishek.ems.dto.AuthResponse;
import com.abhishek.ems.dto.LoginRequest;
import com.abhishek.ems.model.User;
import com.abhishek.ems.repository.UserRepository;
import com.abhishek.ems.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Dummy check, replace with actual user service logic
        List<User> users = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (users != null && users.size() == 1) {
            String token = jwtUtil.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}

