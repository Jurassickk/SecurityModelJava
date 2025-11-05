package com.example.store.application.service;

import com.example.store.application.dto.ProductCategoryDTO;
import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDTO> findAll();
    ProductCategoryDTO findById(Long id);
    ProductCategoryDTO save(ProductCategoryDTO productCategoryDTO);
    ProductCategoryDTO update(Long id, ProductCategoryDTO productCategoryDTO);
    void delete(Long id);
}
