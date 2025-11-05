package com.example.SecurityModel.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SecurityModel.application.dto.RoleUserDTO;
import com.example.SecurityModel.application.service.GenericCrudService;

@RestController
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