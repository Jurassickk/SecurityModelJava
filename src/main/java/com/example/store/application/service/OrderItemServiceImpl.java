package com.example.store.application.service;

import com.example.store.application.dto.OrderItemDTO;
import com.example.store.application.mapper.OrderItemMapper;
import com.example.store.domain.entity.Order;
import com.example.store.domain.entity.OrderItem;
import com.example.store.domain.entity.Product;
import com.example.store.domain.repository.OrderItemRepository;
import com.example.store.domain.repository.OrderRepository;
import com.example.store.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository,
                               OrderRepository orderRepository,
                               ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<OrderItemDTO> findAll() {
        return orderItemRepository.findAll().stream()
                .map(OrderItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO findById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
        return OrderItemMapper.toDTO(orderItem);
    }

    @Override
    public OrderItemDTO save(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = OrderItemMapper.toEntity(orderItemDTO);
        if (orderItemDTO.orderId() != null) {
            Order order = orderRepository.findById(orderItemDTO.orderId())
                    .orElseThrow(() -> new RuntimeException("Order not found"));
            orderItem.setOrder(order);
        }
        if (orderItemDTO.productId() != null) {
            Product product = productRepository.findById(orderItemDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            orderItem.setProduct(product);
        }
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return OrderItemMapper.toDTO(savedOrderItem);
    }

    @Override
    public OrderItemDTO update(Long id, OrderItemDTO orderItemDTO) {
        OrderItem existingOrderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
        existingOrderItem.setQuantity(orderItemDTO.quantity());
        existingOrderItem.setUnitPrice(orderItemDTO.unitPrice());
        if (orderItemDTO.orderId() != null) {
            Order order = orderRepository.findById(orderItemDTO.orderId())
                    .orElseThrow(() -> new RuntimeException("Order not found"));
            existingOrderItem.setOrder(order);
        }
        if (orderItemDTO.productId() != null) {
            Product product = productRepository.findById(orderItemDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            existingOrderItem.setProduct(product);
        }
        OrderItem updatedOrderItem = orderItemRepository.save(existingOrderItem);
        return OrderItemMapper.toDTO(updatedOrderItem);
    }

    @Override
    public void delete(Long id) {
        orderItemRepository.deleteById(id);
    }
}
