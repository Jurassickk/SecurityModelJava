package com.example.store.application.dto;

import java.math.BigDecimal;

public record OrderItemDTO(
    Long id,
    Integer quantity,
    BigDecimal unitPrice,
    Long orderId,
    Long productId
) {}
