package com.example.myapp.service;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}