package com.example.store.application.mapper;

import com.example.store.application.dto.SupplierDTO;
import com.example.store.domain.entity.Supplier;

public class SupplierMapper {

    public static SupplierDTO toDTO(Supplier supplier) {
        return new SupplierDTO(
            supplier.getId(),
            supplier.getName(),
            supplier.getContactEmail(),
            supplier.getPhone()
        );
    }

    public static Supplier toEntity(SupplierDTO dto) {
        return Supplier.builder()
            .name(dto.name())
            .contactEmail(dto.contactEmail())
            .phone(dto.phone())
            .build();
    }
}
