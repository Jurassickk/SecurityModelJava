package com.example.store.application.service;

import com.example.store.application.dto.SupplierDTO;
import com.example.store.application.mapper.SupplierMapper;
import com.example.store.domain.entity.Supplier;
import com.example.store.domain.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierDTO> findAll() {
        return supplierRepository.findAll().stream()
                .map(SupplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDTO findById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        return SupplierMapper.toDTO(supplier);
    }

    @Override
    public SupplierDTO save(SupplierDTO supplierDTO) {
        Supplier supplier = SupplierMapper.toEntity(supplierDTO);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return SupplierMapper.toDTO(savedSupplier);
    }

    @Override
    public SupplierDTO update(Long id, SupplierDTO supplierDTO) {
        Supplier existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        existingSupplier.setName(supplierDTO.name());
        existingSupplier.setContactEmail(supplierDTO.contactEmail());
        existingSupplier.setPhone(supplierDTO.phone());
        Supplier updatedSupplier = supplierRepository.save(existingSupplier);
        return SupplierMapper.toDTO(updatedSupplier);
    }

    @Override
    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }
}
