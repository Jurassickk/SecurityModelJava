package com.example.store.application.mapper;

import com.example.store.application.dto.OrderItemDTO;
import com.example.store.domain.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItemDTO toDTO(OrderItem orderItem) {
        return new OrderItemDTO(
            orderItem.getId(),
            orderItem.getQuantity(),
            orderItem.getUnitPrice(),
            orderItem.getOrder() != null ? orderItem.getOrder().getId() : null,
            orderItem.getProduct() != null ? orderItem.getProduct().getId() : null
        );
    }

    public static OrderItem toEntity(OrderItemDTO dto) {
        return OrderItem.builder()
            .quantity(dto.quantity())
            .unitPrice(dto.unitPrice())
            .build();
    }
}
