package com.abhishek.ems.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String email;
    private String password;
    // Getters and Setters
}