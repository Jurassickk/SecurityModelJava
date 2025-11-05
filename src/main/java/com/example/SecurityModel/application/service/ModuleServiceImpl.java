package com.example.SecurityModel.application.service;

import org.springframework.stereotype.Service;

import com.example.SecurityModel.application.dto.ModuleDTO;
import com.example.SecurityModel.application.mapper.ModuleMapper;
import com.example.SecurityModel.domain.entity.Module;
import com.example.SecurityModel.domain.repository.ModuleRepository;

@Service
public class ModuleServiceImpl extends GenericCrudServiceImpl<Module, ModuleDTO, Long> {

    public ModuleServiceImpl(ModuleRepository moduleRepository, ModuleMapper moduleMapper) {
        super(moduleRepository,
                moduleMapper::toDto,
                moduleMapper::toEntity,
                (entity, dto) -> {
                    Module mod = (Module) entity;
                    ModuleDTO moduleDTO = (ModuleDTO) dto;
                    if (moduleDTO.getName() != null) mod.setName(moduleDTO.getName());
                    if (moduleDTO.getDescription() != null) mod.setDescription(moduleDTO.getDescription());
                });
    }
}
