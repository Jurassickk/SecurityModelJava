package com.example.store.application.mapper;

import com.example.store.application.dto.CustomerDTO;
import com.example.store.domain.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(
            customer.getId(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEmail(),
            customer.getPhone()
        );
    }

    public static Customer toEntity(CustomerDTO dto) {
        return Customer.builder()
            .firstName(dto.firstName())
            .lastName(dto.lastName())
            .email(dto.email())
            .phone(dto.phone())
            .build();
    }
}
