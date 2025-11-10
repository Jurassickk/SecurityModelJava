package com.example.store.infrastructure.controller;

import com.example.store.application.dto.ProductSupplierDTO;
import com.example.store.application.service.ProductSupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/api/product-suppliers")
public class ProductSupplierController {

    private final ProductSupplierService productSupplierService;

    public ProductSupplierController(ProductSupplierService productSupplierService) {
        this.productSupplierService = productSupplierService;
    }

    @GetMapping
    public ResponseEntity<List<ProductSupplierDTO>> findAll() {
        return ResponseEntity.ok(productSupplierService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductSupplierDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productSupplierService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductSupplierDTO> save(@RequestBody ProductSupplierDTO productSupplierDTO) {
        return ResponseEntity.ok(productSupplierService.save(productSupplierDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductSupplierDTO> update(@PathVariable Long id, @RequestBody ProductSupplierDTO productSupplierDTO) {
        return ResponseEntity.ok(productSupplierService.update(id, productSupplierDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productSupplierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
