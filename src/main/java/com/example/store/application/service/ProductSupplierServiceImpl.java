package com.example.store.application.service;

import com.example.store.application.dto.ProductSupplierDTO;
import com.example.store.application.mapper.ProductSupplierMapper;
import com.example.store.domain.entity.Product;
import com.example.store.domain.entity.ProductSupplier;
import com.example.store.domain.entity.Supplier;
import com.example.store.domain.repository.ProductRepository;
import com.example.store.domain.repository.ProductSupplierRepository;
import com.example.store.domain.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductSupplierServiceImpl implements ProductSupplierService {

    private final ProductSupplierRepository productSupplierRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ProductSupplierServiceImpl(ProductSupplierRepository productSupplierRepository,
                                     ProductRepository productRepository,
                                     SupplierRepository supplierRepository) {
        this.productSupplierRepository = productSupplierRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<ProductSupplierDTO> findAll() {
        return productSupplierRepository.findAll().stream()
                .map(ProductSupplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductSupplierDTO findById(Long id) {
        ProductSupplier productSupplier = productSupplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductSupplier not found"));
        return ProductSupplierMapper.toDTO(productSupplier);
    }

    @Override
    public ProductSupplierDTO save(ProductSupplierDTO productSupplierDTO) {
        ProductSupplier productSupplier = ProductSupplierMapper.toEntity(productSupplierDTO);
        if (productSupplierDTO.productId() != null) {
            Product product = productRepository.findById(productSupplierDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            productSupplier.setProduct(product);
        }
        if (productSupplierDTO.supplierId() != null) {
            Supplier supplier = supplierRepository.findById(productSupplierDTO.supplierId())
                    .orElseThrow(() -> new RuntimeException("Supplier not found"));
            productSupplier.setSupplier(supplier);
        }
        ProductSupplier savedProductSupplier = productSupplierRepository.save(productSupplier);
        return ProductSupplierMapper.toDTO(savedProductSupplier);
    }

    @Override
    public ProductSupplierDTO update(Long id, ProductSupplierDTO productSupplierDTO) {
        ProductSupplier existingProductSupplier = productSupplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductSupplier not found"));
        if (productSupplierDTO.productId() != null) {
            Product product = productRepository.findById(productSupplierDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            existingProductSupplier.setProduct(product);
        }
        if (productSupplierDTO.supplierId() != null) {
            Supplier supplier = supplierRepository.findById(productSupplierDTO.supplierId())
                    .orElseThrow(() -> new RuntimeException("Supplier not found"));
            existingProductSupplier.setSupplier(supplier);
        }
        ProductSupplier updatedProductSupplier = productSupplierRepository.save(existingProductSupplier);
        return ProductSupplierMapper.toDTO(updatedProductSupplier);
    }

    @Override
    public void delete(Long id) {
        productSupplierRepository.deleteById(id);
    }
}
