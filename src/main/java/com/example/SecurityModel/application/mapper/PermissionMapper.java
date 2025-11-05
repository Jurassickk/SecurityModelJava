package com.example.SecurityModel.application.mapper;

import org.springframework.stereotype.Component;

import com.example.SecurityModel.application.dto.PermissionDTO;
import com.example.SecurityModel.domain.entity.Permission;

@Component
public class PermissionMapper {

    public PermissionDTO toDto(Permission permission) {
        if (permission == null) return null;
        return PermissionDTO.builder()
                .id(permission.getId())
                .name(permission.getName())
                .description(permission.getDescription())
                .build();
    }

    public Permission toEntity(PermissionDTO permissionDTO) {
        if (permissionDTO == null) return null;
        Permission permission = new Permission();
        permission.setName(permissionDTO.getName());
        permission.setDescription(permissionDTO.getDescription());
        return permission;
    }
}