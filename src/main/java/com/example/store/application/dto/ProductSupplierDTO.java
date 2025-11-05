package com.example.store.application.dto;

public record ProductSupplierDTO(
    Long id,
    Long productId,
    Long supplierId
) {}
