package com.example.store.application.dto;

public record CustomerDTO(
    Long id,
    String firstName,
    String lastName,
    String email,
    String phone
) {}
