package com.example.SecurityModel.application.service;

import com.example.SecurityModel.application.dto.RoleDTO;
import com.example.SecurityModel.application.mapper.RoleMapper;
import com.example.SecurityModel.domain.entity.Role;
import com.example.SecurityModel.domain.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends GenericCrudServiceImpl<Role, RoleDTO, Long>{

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        super(roleRepository,
                roleMapper::toDto,
                roleMapper::toEntity,
                (entity, dto) -> {
                    if (dto.getName() != null) entity.setName(dto.getName());
                    if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
                });
    }
}
