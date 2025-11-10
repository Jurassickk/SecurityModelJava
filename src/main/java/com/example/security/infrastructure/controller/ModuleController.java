package com.example.security.infrastructure.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.application.dto.ModuleDTO;
import com.example.security.application.service.GenericCrudService;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/api/modules")
public class ModuleController extends BaseController<ModuleDTO, Long> {

    private final GenericCrudService<ModuleDTO, Long> moduleService;

    public ModuleController(GenericCrudService<ModuleDTO, Long> moduleService) {
        this.moduleService = moduleService;
    }

    @Override
    protected GenericCrudService<ModuleDTO, Long> getService() {
        return moduleService;
    }
}
