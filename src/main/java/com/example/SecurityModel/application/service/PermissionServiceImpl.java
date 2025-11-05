package com.example.SecurityModel.application.service;

import org.springframework.stereotype.Service;

import com.example.SecurityModel.application.dto.PermissionDTO;
import com.example.SecurityModel.application.mapper.PermissionMapper;
import com.example.SecurityModel.domain.entity.Permission;
import com.example.SecurityModel.domain.repository.PermissionRepository;

@Service
public class PermissionServiceImpl extends GenericCrudServiceImpl<Permission, PermissionDTO, Long> {

    public PermissionServiceImpl(PermissionRepository permissionRepository, PermissionMapper permissionMapper) {
        super(permissionRepository,
                permissionMapper::toDto,
                permissionMapper::toEntity,
                (entity, dto) -> {
                    if (dto.getName() != null) entity.setName(dto.getName());
                    if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
                });
    }
}