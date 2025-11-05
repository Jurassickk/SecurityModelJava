package com.example.security.application.service;

import org.springframework.stereotype.Service;

import com.example.security.application.dto.FormModuleDTO;
import com.example.security.application.mapper.FormModuleMapper;
import com.example.security.domain.entity.FormModule;
import com.example.security.domain.repository.FormModuleRepository;

@Service
public class FormModuleServiceImpl extends GenericCrudServiceImpl<FormModule, FormModuleDTO, Long> {

    public FormModuleServiceImpl(FormModuleRepository formModuleRepository, FormModuleMapper formModuleMapper) {
        super(formModuleRepository,
                formModuleMapper::toDto,
                formModuleMapper::toEntity,
                (entity, dto) -> {
                    // Note: Relationships are handled by the entity relationships
                });
    }
}
