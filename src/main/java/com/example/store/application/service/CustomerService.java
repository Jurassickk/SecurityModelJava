package com.example.store.application.service;

import com.example.store.application.dto.CustomerDTO;
import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll();
    CustomerDTO findById(Long id);
    CustomerDTO save(CustomerDTO customerDTO);
    CustomerDTO update(Long id, CustomerDTO customerDTO);
    void delete(Long id);
}
