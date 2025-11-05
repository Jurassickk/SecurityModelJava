package com.example.SecurityModel.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SecurityModel.application.dto.RoleModulePermissionDTO;
import com.example.SecurityModel.application.service.GenericCrudService;

@RestController
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