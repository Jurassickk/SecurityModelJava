package com.example.SecurityModel.application.service;

import com.example.SecurityModel.application.dto.AuthResponse;
import com.example.SecurityModel.application.dto.LoginRequest;

public interface AuthService {
    AuthResponse authenticate(LoginRequest loginRequest);
}