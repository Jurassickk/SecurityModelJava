package com.example.store.application.service;

import com.example.store.application.dto.OrderItemDTO;
import java.util.List;

public interface OrderItemService {
    List<OrderItemDTO> findAll();
    OrderItemDTO findById(Long id);
    OrderItemDTO save(OrderItemDTO orderItemDTO);
    OrderItemDTO update(Long id, OrderItemDTO orderItemDTO);
    void delete(Long id);
}
