package com.example.SecurityModel.application.mapper;

import org.springframework.stereotype.Component;

import com.example.SecurityModel.application.dto.RoleDTO;
import com.example.SecurityModel.domain.entity.Role;

@Component
public class RoleMapper {

    public RoleDTO toDto(Role role) {
        if (role == null) return null;
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

    public Role toEntity(RoleDTO roleDTO) {
        if (roleDTO == null) return null;
        Role role = new Role();
        role.setName(roleDTO.getName());
        role.setDescription(roleDTO.getDescription());
        return role;
    }
}
