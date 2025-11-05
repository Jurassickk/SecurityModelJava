package com.example.store.application.mapper;

import com.example.store.application.dto.CategoryDTO;
import com.example.store.domain.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category category) {
        return new CategoryDTO(
            category.getId(),
            category.getName(),
            category.getDescription()
        );
    }

    public static Category toEntity(CategoryDTO dto) {
        return Category.builder()
            .name(dto.name())
            .description(dto.description())
            .build();
    }
}
