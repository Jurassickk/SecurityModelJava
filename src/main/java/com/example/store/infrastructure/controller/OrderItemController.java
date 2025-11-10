package com.example.store.infrastructure.controller;

import com.example.store.application.dto.OrderItemDTO;
import com.example.store.application.service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> findAll() {
        return ResponseEntity.ok(orderItemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderItemService.findById(id));
    }

    @PostMapping
    public ResponseEntity<OrderItemDTO> save(@RequestBody OrderItemDTO orderItemDTO) {
        return ResponseEntity.ok(orderItemService.save(orderItemDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDTO> update(@PathVariable Long id, @RequestBody OrderItemDTO orderItemDTO) {
        return ResponseEntity.ok(orderItemService.update(id, orderItemDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
