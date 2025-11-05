package com.example.SecurityModel.application.mapper;

import org.springframework.stereotype.Component;

import com.example.SecurityModel.application.dto.ModuleDTO;
import com.example.SecurityModel.domain.entity.Module;

@Component
public class ModuleMapper {

    public ModuleDTO toDto(Module module) {
        if (module == null) return null;
        return ModuleDTO.builder()
                .id(module.getId())
                .name(module.getName())
                .description(module.getDescription())
                .build();
    }

    public Module toEntity(ModuleDTO moduleDTO) {
        if (moduleDTO == null) return null;
        Module module = new Module();
        module.setName(moduleDTO.getName());
        module.setDescription(moduleDTO.getDescription());
        return module;
    }
}