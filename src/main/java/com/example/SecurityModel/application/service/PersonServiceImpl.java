package com.example.SecurityModel.application.service;

import org.springframework.stereotype.Service;

import com.example.SecurityModel.application.dto.PersonDTO;
import com.example.SecurityModel.application.mapper.PersonMapper;
import com.example.SecurityModel.domain.entity.Person;
import com.example.SecurityModel.domain.repository.PersonRepository;

@Service
public class PersonServiceImpl extends GenericCrudServiceImpl<Person, PersonDTO, Long> {

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        super(personRepository,
                personMapper::toDto,
                personMapper::toEntity,
                (entity, dto) -> {
                    if (dto.getFirstName() != null) entity.setFirstName(dto.getFirstName());
                    if (dto.getLastName() != null) entity.setLastName(dto.getLastName());
                    if (dto.getDocumentType() != null) entity.setDocumentType(dto.getDocumentType());
                    if (dto.getDocumentNumber() != null) entity.setDocumentNumber(dto.getDocumentNumber());
                    if (dto.getPhoneNumber() != null) entity.setPhoneNumber(dto.getPhoneNumber());
                    if (dto.getGender() != null) entity.setGender(dto.getGender());
                    if (dto.getActive() != null) entity.setActive(dto.getActive());
                    if (dto.getCityId() != null) entity.setCityId(dto.getCityId());
                });
    }
}