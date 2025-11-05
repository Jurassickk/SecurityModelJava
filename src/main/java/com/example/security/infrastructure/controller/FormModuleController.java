package com.example.security.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.application.dto.FormModuleDTO;
import com.example.security.application.service.GenericCrudService;

@RestController
@RequestMapping("/api/form-modules")
public class FormModuleController extends BaseController<FormModuleDTO, Long> {

    private final GenericCrudService<FormModuleDTO, Long> formModuleService;

    public FormModuleController(GenericCrudService<FormModuleDTO, Long> formModuleService) {
        this.formModuleService = formModuleService;
    }

    @Override
    protected GenericCrudService<FormModuleDTO, Long> getService() {
        return formModuleService;
    }
}
