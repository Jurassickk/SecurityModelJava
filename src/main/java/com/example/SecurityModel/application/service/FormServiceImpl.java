package com.example.SecurityModel.application.service;

import org.springframework.stereotype.Service;

import com.example.SecurityModel.application.dto.FormDTO;
import com.example.SecurityModel.application.mapper.FormMapper;
import com.example.SecurityModel.domain.entity.Form;
import com.example.SecurityModel.domain.repository.FormRepository;

@Service
public class FormServiceImpl extends GenericCrudServiceImpl<Form, FormDTO, Long> {

    public FormServiceImpl(FormRepository formRepository, FormMapper formMapper) {
        super(formRepository,
                formMapper::toDto,
                formMapper::toEntity,
                (entity, dto) -> {
                    if (dto.getName() != null) entity.setName(dto.getName());
                    if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
                    if (dto.getUrl() != null) entity.setUrl(dto.getUrl());
                });
    }
}