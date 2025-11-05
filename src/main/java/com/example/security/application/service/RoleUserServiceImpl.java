package com.example.security.application.service;

import org.springframework.stereotype.Service;

import com.example.security.application.dto.RoleUserDTO;
import com.example.security.application.mapper.RoleUserMapper;
import com.example.security.domain.entity.RoleUser;
import com.example.security.domain.repository.RoleUserRepository;

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
