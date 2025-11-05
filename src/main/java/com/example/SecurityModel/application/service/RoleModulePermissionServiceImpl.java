package com.example.SecurityModel.application.service;

import org.springframework.stereotype.Service;

import com.example.SecurityModel.application.dto.RoleModulePermissionDTO;
import com.example.SecurityModel.application.mapper.RoleModulePermissionMapper;
import com.example.SecurityModel.domain.entity.RoleModulePermission;
import com.example.SecurityModel.domain.repository.RoleModulePermissionRepository;

@Service
public class RoleModulePermissionServiceImpl extends GenericCrudServiceImpl<RoleModulePermission, RoleModulePermissionDTO, Long> {

    public RoleModulePermissionServiceImpl(RoleModulePermissionRepository roleModulePermissionRepository, RoleModulePermissionMapper roleModulePermissionMapper) {
        super(roleModulePermissionRepository,
                roleModulePermissionMapper::toDto,
                roleModulePermissionMapper::toEntity,
                (entity, dto) -> {
                    // Note: Relationships are handled by the entity relationships
                });
    }
}