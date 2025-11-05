package com.example.store.application.service;

import com.example.store.application.dto.ProductCategoryDTO;
import com.example.store.application.mapper.ProductCategoryMapper;
import com.example.store.domain.entity.Category;
import com.example.store.domain.entity.Product;
import com.example.store.domain.entity.ProductCategory;
import com.example.store.domain.repository.CategoryRepository;
import com.example.store.domain.repository.ProductCategoryRepository;
import com.example.store.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository,
                                     ProductRepository productRepository,
                                     CategoryRepository categoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductCategoryDTO> findAll() {
        return productCategoryRepository.findAll().stream()
                .map(ProductCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductCategoryDTO findById(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductCategory not found"));
        return ProductCategoryMapper.toDTO(productCategory);
    }

    @Override
    public ProductCategoryDTO save(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = ProductCategoryMapper.toEntity(productCategoryDTO);
        if (productCategoryDTO.productId() != null) {
            Product product = productRepository.findById(productCategoryDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            productCategory.setProduct(product);
        }
        if (productCategoryDTO.categoryId() != null) {
            Category category = categoryRepository.findById(productCategoryDTO.categoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            productCategory.setCategory(category);
        }
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return ProductCategoryMapper.toDTO(savedProductCategory);
    }

    @Override
    public ProductCategoryDTO update(Long id, ProductCategoryDTO productCategoryDTO) {
        ProductCategory existingProductCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductCategory not found"));
        if (productCategoryDTO.productId() != null) {
            Product product = productRepository.findById(productCategoryDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            existingProductCategory.setProduct(product);
        }
        if (productCategoryDTO.categoryId() != null) {
            Category category = categoryRepository.findById(productCategoryDTO.categoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            existingProductCategory.setCategory(category);
        }
        ProductCategory updatedProductCategory = productCategoryRepository.save(existingProductCategory);
        return ProductCategoryMapper.toDTO(updatedProductCategory);
    }

    @Override
    public void delete(Long id) {
        productCategoryRepository.deleteById(id);
    }
}
