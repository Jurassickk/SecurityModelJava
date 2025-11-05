package com.example.store.infrastructure.controller;

import com.example.store.application.dto.ProductCategoryDTO;
import com.example.store.application.service.ProductCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-categories")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryDTO>> findAll() {
        return ResponseEntity.ok(productCategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductCategoryDTO> save(@RequestBody ProductCategoryDTO productCategoryDTO) {
        return ResponseEntity.ok(productCategoryService.save(productCategoryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> update(@PathVariable Long id, @RequestBody ProductCategoryDTO productCategoryDTO) {
        return ResponseEntity.ok(productCategoryService.update(id, productCategoryDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
