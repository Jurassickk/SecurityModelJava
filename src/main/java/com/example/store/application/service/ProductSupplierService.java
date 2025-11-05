package com.example.store.application.service;

import com.example.store.application.dto.ProductSupplierDTO;
import java.util.List;

public interface ProductSupplierService {
    List<ProductSupplierDTO> findAll();
    ProductSupplierDTO findById(Long id);
    ProductSupplierDTO save(ProductSupplierDTO productSupplierDTO);
    ProductSupplierDTO update(Long id, ProductSupplierDTO productSupplierDTO);
    void delete(Long id);
}
