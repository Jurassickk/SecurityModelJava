package com.example.security.application.service;

import java.util.List;
import java.util.Optional;

public interface GenericCrudService<DTO, ID> {

    DTO create(DTO dto);
    Optional<DTO> findById(ID id);
    List<DTO> findAll();
    DTO update(ID id, DTO dto);
    void delete(ID id);
}
