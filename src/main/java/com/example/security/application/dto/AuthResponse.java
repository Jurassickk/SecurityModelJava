package com.example.security.application.dto;

import java.util.List;

public record AuthResponse(
    String token,
    String type,
    Long id,
    String email,
    List<String> roles
) {
    public AuthResponse(String token, Long id, String email, List<String> roles) {
        this(token, "Bearer", id, email, roles);
    }
}
