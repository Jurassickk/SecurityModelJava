package com.example.security.application.service;

import org.springframework.stereotype.Service;

import com.example.security.application.dto.RoleModulePermissionDTO;
import com.example.security.application.mapper.RoleModulePermissionMapper;
import com.example.security.domain.entity.RoleModulePermission;
import com.example.security.domain.repository.RoleModulePermissionRepository;

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
