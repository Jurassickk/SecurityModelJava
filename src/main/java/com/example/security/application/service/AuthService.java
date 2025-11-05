package com.example.security.application.service;

import com.example.security.application.dto.AuthResponse;
import com.example.security.application.dto.LoginRequest;

public interface AuthService {
    AuthResponse authenticate(LoginRequest loginRequest);
}
