package com.example.store.application.service;

import com.example.store.application.dto.CategoryDTO;
import com.example.store.application.mapper.CategoryMapper;
import com.example.store.domain.entity.Category;
import com.example.store.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return CategoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.toDTO(savedCategory);
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existingCategory.setName(categoryDTO.name());
        existingCategory.setDescription(categoryDTO.description());
        Category updatedCategory = categoryRepository.save(existingCategory);
        return CategoryMapper.toDTO(updatedCategory);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
