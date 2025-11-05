package com.example.store.application.mapper;

import com.example.store.application.dto.ProductSupplierDTO;
import com.example.store.domain.entity.ProductSupplier;

public class ProductSupplierMapper {

    public static ProductSupplierDTO toDTO(ProductSupplier productSupplier) {
        return new ProductSupplierDTO(
            productSupplier.getId(),
            productSupplier.getProduct() != null ? productSupplier.getProduct().getId() : null,
            productSupplier.getSupplier() != null ? productSupplier.getSupplier().getId() : null
        );
    }

    public static ProductSupplier toEntity(ProductSupplierDTO dto) {
        return ProductSupplier.builder()
            .build();
    }
}
