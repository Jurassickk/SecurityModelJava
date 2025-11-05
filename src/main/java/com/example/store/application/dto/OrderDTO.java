package com.example.store.application.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderDTO(
    Long id,
    Instant orderDate,
    BigDecimal totalAmount,
    String status,
    Long customerId
) {}
