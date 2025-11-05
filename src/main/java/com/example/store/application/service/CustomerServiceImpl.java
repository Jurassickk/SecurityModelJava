package com.example.store.application.service;

import com.example.store.application.dto.CustomerDTO;
import com.example.store.application.mapper.CustomerMapper;
import com.example.store.domain.entity.Customer;
import com.example.store.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return CustomerMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDTO(savedCustomer);
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO customerDTO) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        existingCustomer.setFirstName(customerDTO.firstName());
        existingCustomer.setLastName(customerDTO.lastName());
        existingCustomer.setEmail(customerDTO.email());
        existingCustomer.setPhone(customerDTO.phone());
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return CustomerMapper.toDTO(updatedCustomer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
