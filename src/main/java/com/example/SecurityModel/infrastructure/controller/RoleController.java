package com.example.SecurityModel.infrastructure.controller;

import com.example.SecurityModel.application.dto.RoleDTO;
import com.example.SecurityModel.application.service.GenericCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
