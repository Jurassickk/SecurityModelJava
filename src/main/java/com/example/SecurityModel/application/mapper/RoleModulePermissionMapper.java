package com.example.SecurityModel.application.mapper;

import org.springframework.stereotype.Component;

import com.example.SecurityModel.application.dto.RoleModulePermissionDTO;
import com.example.SecurityModel.domain.entity.RoleModulePermission;

@Component
public class RoleModulePermissionMapper {

    public RoleModulePermissionDTO toDto(RoleModulePermission roleModulePermission) {
        if (roleModulePermission == null) return null;
        return RoleModulePermissionDTO.builder()
                .id(roleModulePermission.getId())
                .roleId(roleModulePermission.getRole() != null ? roleModulePermission.getRole().getId() : null)
                .permissionId(roleModulePermission.getPermission() != null ? roleModulePermission.getPermission().getId() : null)
                .moduleId(roleModulePermission.getModule() != null ? roleModulePermission.getModule().getId() : null)
                .build();
    }

    public RoleModulePermission toEntity(RoleModulePermissionDTO roleModulePermissionDTO) {
        if (roleModulePermissionDTO == null) return null;
        RoleModulePermission roleModulePermission = new RoleModulePermission();
        // Note: Relationships should be set by service layer
        return roleModulePermission;
    }
}