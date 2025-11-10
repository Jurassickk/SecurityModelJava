package com.example.security.infrastructure.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.application.dto.FormDTO;
import com.example.security.application.service.GenericCrudService;

@RestController
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/api/forms")
public class FormController extends BaseController<FormDTO, Long> {

    private final GenericCrudService<FormDTO, Long> formService;

    public FormController(GenericCrudService<FormDTO, Long> formService) {
        this.formService = formService;
    }

    @Override
    protected GenericCrudService<FormDTO, Long> getService() {
        return formService;
    }
}
