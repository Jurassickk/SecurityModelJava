package com.example.store.application.service;

import com.example.store.application.dto.SupplierDTO;
import java.util.List;

public interface SupplierService {
    List<SupplierDTO> findAll();
    SupplierDTO findById(Long id);
    SupplierDTO save(SupplierDTO supplierDTO);
    SupplierDTO update(Long id, SupplierDTO supplierDTO);
    void delete(Long id);
}
