package com.example.store.application.mapper;

import com.example.store.application.dto.ProductDTO;
import com.example.store.domain.entity.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStock()
        );
    }

    public static Product toEntity(ProductDTO dto) {
        return Product.builder()
            .name(dto.name())
            .description(dto.description())
            .price(dto.price())
            .stock(dto.stock())
            .build();
    }
}
