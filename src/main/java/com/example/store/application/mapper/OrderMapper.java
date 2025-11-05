package com.example.store.application.mapper;

import com.example.store.application.dto.OrderDTO;
import com.example.store.domain.entity.Order;

public class OrderMapper {

    public static OrderDTO toDTO(Order order) {
        return new OrderDTO(
            order.getId(),
            order.getOrderDate(),
            order.getTotalAmount(),
            order.getStatus(),
            order.getCustomer() != null ? order.getCustomer().getId() : null
        );
    }

    public static Order toEntity(OrderDTO dto) {
        return Order.builder()
            .orderDate(dto.orderDate())
            .totalAmount(dto.totalAmount())
            .status(dto.status())
            .build();
    }
}
