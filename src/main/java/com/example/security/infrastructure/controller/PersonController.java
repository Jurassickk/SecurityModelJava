package com.example.security.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.application.dto.PersonDTO;
import com.example.security.application.service.GenericCrudService;

@RestController
@RequestMapping("/api/persons")
public class PersonController extends BaseController<PersonDTO, Long> {

    private final GenericCrudService<PersonDTO, Long> personService;

    public PersonController(GenericCrudService<PersonDTO, Long> personService) {
        this.personService = personService;
    }

    @Override
    protected GenericCrudService<PersonDTO, Long> getService() {
        return personService;
    }
}
