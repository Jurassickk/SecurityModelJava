package com.example.security.infrastructure.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.application.dto.RoleModulePermissionDTO;
import com.example.security.application.service.GenericCrudService;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/api/role-module-permissions")
public class RoleModulePermissionController extends BaseController<RoleModulePermissionDTO, Long> {

    private final GenericCrudService<RoleModulePermissionDTO, Long> roleModulePermissionService;

    public RoleModulePermissionController(GenericCrudService<RoleModulePermissionDTO, Long> roleModulePermissionService) {
        this.roleModulePermissionService = roleModulePermissionService;
    }

    @Override
    protected GenericCrudService<RoleModulePermissionDTO, Long> getService() {
        return roleModulePermissionService;
    }
}
