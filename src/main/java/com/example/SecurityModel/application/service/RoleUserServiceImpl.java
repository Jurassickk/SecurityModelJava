package com.example.SecurityModel.application.service;

import org.springframework.stereotype.Service;

import com.example.SecurityModel.application.dto.RoleUserDTO;
import com.example.SecurityModel.application.mapper.RoleUserMapper;
import com.example.SecurityModel.domain.entity.RoleUser;
import com.example.SecurityModel.domain.repository.RoleUserRepository;

@Service
public class RoleUserServiceImpl extends GenericCrudServiceImpl<RoleUser, RoleUserDTO, Long> {

    public RoleUserServiceImpl(RoleUserRepository roleUserRepository, RoleUserMapper roleUserMapper) {
        super(roleUserRepository,
                roleUserMapper::toDto,
                roleUserMapper::toEntity,
                (entity, dto) -> {
                    // Note: Relationships are handled by the entity relationships
                });
    }
}