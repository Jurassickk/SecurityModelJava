package com.example.security.application.mapper;

import org.springframework.stereotype.Component;

import com.example.security.application.dto.PersonDTO;
import com.example.security.domain.entity.Person;

@Component
public class PersonMapper {

    public PersonDTO toDto(Person person) {
        if (person == null) return null;
        return PersonDTO.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .documentType(person.getDocumentType())
                .documentNumber(person.getDocumentNumber())
                .phoneNumber(person.getPhoneNumber())
                .gender(person.getGender())
                .active(person.isActive())
                .cityId(person.getCityId())
                .userId(person.getUser() != null ? person.getUser().getId() : null)
                .build();
    }

    public Person toEntity(PersonDTO personDTO) {
        if (personDTO == null) return null;
        Person person = new Person();
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setDocumentType(personDTO.getDocumentType());
        person.setDocumentNumber(personDTO.getDocumentNumber());
        person.setPhoneNumber(personDTO.getPhoneNumber());
        person.setGender(personDTO.getGender());
        person.setActive(personDTO.getActive());
        person.setCityId(personDTO.getCityId());
        return person;
    }
}
