package com.example.store.application.mapper;

import com.example.store.application.dto.ProductCategoryDTO;
import com.example.store.domain.entity.ProductCategory;

public class ProductCategoryMapper {

    public static ProductCategoryDTO toDTO(ProductCategory productCategory) {
        return new ProductCategoryDTO(
            productCategory.getId(),
            productCategory.getProduct() != null ? productCategory.getProduct().getId() : null,
            productCategory.getCategory() != null ? productCategory.getCategory().getId() : null
        );
    }

    public static ProductCategory toEntity(ProductCategoryDTO dto) {
        return ProductCategory.builder()
            .build();
    }
}
