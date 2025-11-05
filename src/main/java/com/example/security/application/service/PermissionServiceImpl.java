package com.example.security.application.service;

import org.springframework.stereotype.Service;

import com.example.security.application.dto.PermissionDTO;
import com.example.security.application.mapper.PermissionMapper;
import com.example.security.domain.entity.Permission;
import com.example.security.domain.repository.PermissionRepository;

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
