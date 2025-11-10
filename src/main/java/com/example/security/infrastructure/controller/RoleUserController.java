package com.example.security.infrastructure.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.application.dto.RoleUserDTO;
import com.example.security.application.service.GenericCrudService;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/api/role-users")
public class RoleUserController extends BaseController<RoleUserDTO, Long> {

    private final GenericCrudService<RoleUserDTO, Long> roleUserService;

    public RoleUserController(GenericCrudService<RoleUserDTO, Long> roleUserService) {
        this.roleUserService = roleUserService;
    }

    @Override
    protected GenericCrudService<RoleUserDTO, Long> getService() {
        return roleUserService;
    }
}
