package com.example.SecurityModel.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SecurityModel.application.dto.ModuleDTO;
import com.example.SecurityModel.application.service.GenericCrudService;

@RestController
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