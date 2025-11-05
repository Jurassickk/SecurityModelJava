package com.example.SecurityModel.application.service;

import org.springframework.stereotype.Service;

import com.example.SecurityModel.application.dto.FormModuleDTO;
import com.example.SecurityModel.application.mapper.FormModuleMapper;
import com.example.SecurityModel.domain.entity.FormModule;
import com.example.SecurityModel.domain.repository.FormModuleRepository;

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