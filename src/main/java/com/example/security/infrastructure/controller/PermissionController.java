package com.example.security.infrastructure.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.application.dto.PermissionDTO;
import com.example.security.application.service.GenericCrudService;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/api/permissions")
public class PermissionController extends BaseController<PermissionDTO, Long> {

    private final GenericCrudService<PermissionDTO, Long> permissionService;

    public PermissionController(GenericCrudService<PermissionDTO, Long> permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    protected GenericCrudService<PermissionDTO, Long> getService() {
        return permissionService;
    }
}
