package com.example.SecurityModel.application.mapper;

import org.springframework.stereotype.Component;

import com.example.SecurityModel.application.dto.RoleUserDTO;
import com.example.SecurityModel.domain.entity.RoleUser;

@Component
public class RoleUserMapper {

    public RoleUserDTO toDto(RoleUser roleUser) {
        if (roleUser == null) return null;
        return RoleUserDTO.builder()
                .id(roleUser.getId())
                .roleId(roleUser.getRole() != null ? roleUser.getRole().getId() : null)
                .userId(roleUser.getUser() != null ? roleUser.getUser().getId() : null)
                .build();
    }

    public RoleUser toEntity(RoleUserDTO roleUserDTO) {
        if (roleUserDTO == null) return null;
        RoleUser roleUser = new RoleUser();
        // Note: Relationships should be set by service layer
        return roleUser;
    }
}