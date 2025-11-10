package com.example.security.infrastructure.controller;

import com.example.security.application.dto.RoleDTO;
import com.example.security.application.service.GenericCrudService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/api/roles")
public class RoleController extends BaseController<RoleDTO, Long>{

    private final GenericCrudService<RoleDTO, Long> roleService;

    public RoleController(GenericCrudService<RoleDTO, Long> roleService) {
        this.roleService = roleService;
    }

    @Override
    protected GenericCrudService<RoleDTO, Long> getService() {
        return roleService;
    }
}
