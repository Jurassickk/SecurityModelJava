package com.example.security.application.mapper;

import org.springframework.stereotype.Component;

import com.example.security.application.dto.FormModuleDTO;
import com.example.security.domain.entity.FormModule;

@Component
public class FormModuleMapper {

    public FormModuleDTO toDto(FormModule formModule) {
        if (formModule == null) return null;
        return FormModuleDTO.builder()
                .id(formModule.getId())
                .formId(formModule.getForm() != null ? formModule.getForm().getId() : null)
                .moduleId(formModule.getModule() != null ? formModule.getModule().getId() : null)
                .build();
    }

    public FormModule toEntity(FormModuleDTO formModuleDTO) {
        if (formModuleDTO == null) return null;
        FormModule formModule = new FormModule();
        // Note: Relationships should be set by service layer
        return formModule;
    }
}
