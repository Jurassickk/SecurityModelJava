package com.example.store.domain.repository;

import com.example.store.domain.entity.ProductSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, Long> {
}
