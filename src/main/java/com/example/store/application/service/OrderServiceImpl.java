package com.example.store.application.service;

import com.example.store.application.dto.OrderDTO;
import com.example.store.application.mapper.OrderMapper;
import com.example.store.domain.entity.Customer;
import com.example.store.domain.entity.Order;
import com.example.store.domain.repository.CustomerRepository;
import com.example.store.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderMapper.toDTO(order);
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = OrderMapper.toEntity(orderDTO);
        if (orderDTO.customerId() != null) {
            Customer customer = customerRepository.findById(orderDTO.customerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            order.setCustomer(customer);
        }
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toDTO(savedOrder);
    }

    @Override
    public OrderDTO update(Long id, OrderDTO orderDTO) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        existingOrder.setOrderDate(orderDTO.orderDate());
        existingOrder.setTotalAmount(orderDTO.totalAmount());
        existingOrder.setStatus(orderDTO.status());
        if (orderDTO.customerId() != null) {
            Customer customer = customerRepository.findById(orderDTO.customerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            existingOrder.setCustomer(customer);
        }
        Order updatedOrder = orderRepository.save(existingOrder);
        return OrderMapper.toDTO(updatedOrder);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
