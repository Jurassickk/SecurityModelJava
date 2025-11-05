package com.example.store.application.service;

import com.example.store.application.dto.OrderDTO;
import java.util.List;

public interface OrderService {
    List<OrderDTO> findAll();
    OrderDTO findById(Long id);
    OrderDTO save(OrderDTO orderDTO);
    OrderDTO update(Long id, OrderDTO orderDTO);
    void delete(Long id);
}
