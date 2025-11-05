package com.example.SecurityModel.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SecurityModel.application.dto.PermissionDTO;
import com.example.SecurityModel.application.service.GenericCrudService;

@RestController
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