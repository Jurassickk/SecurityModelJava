package com.example.security.application.mapper;

import org.springframework.stereotype.Component;

import com.example.security.application.dto.FormDTO;
import com.example.security.domain.entity.Form;

@Component
public class FormMapper {

    public FormDTO toDto(Form form) {
        if (form == null) return null;
        return FormDTO.builder()
                .id(form.getId())
                .name(form.getName())
                .description(form.getDescription())
                .url(form.getUrl())
                .build();
    }

    public Form toEntity(FormDTO formDTO) {
        if (formDTO == null) return null;
        Form form = new Form();
        form.setName(formDTO.getName());
        form.setDescription(formDTO.getDescription());
        form.setUrl(formDTO.getUrl());
        return form;
    }
}
