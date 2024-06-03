package com.example.bankingsystem.service.impl;

import com.example.bankingsystem.dto.CustomerDto;
import com.example.bankingsystem.entity.Customer;
import com.example.bankingsystem.repository.CustomerRepository;
import com.example.bankingsystem.service.AccountService;
import com.example.bankingsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountService accountService;
    @Override
    public CustomerDto customerToCustomerDto(Customer c) {
        return CustomerDto.builder()
                .id(c.getId())
                .name(c.getName())
                .address(c.getAddress())
                .phone(c.getPhone())
                .email(c.getEmail())
                .accounts(c.getAccounts().stream()
                        .map(accountService::accountToAccountDto)
                        .collect(Collectors.toSet()))
                .build();
    }

    @Override
    public Customer detailedCustomerToCustomerDto(CustomerDto c) {
        return Customer.builder()
                .id(c.getId())
                .name(c.getName())
                .address(c.getAddress())
                .phone(c.getPhone())
                .email(c.getEmail())
                .build();
    }

    @Override
    public String createCustomer(CustomerDto customer) {
        customerRepository.save(detailedCustomerToCustomerDto(customer));
        return "Customer has been saved";
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(c -> customerToCustomerDto(c)).toList();
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Customer doesnt exist"));
        return customerToCustomerDto(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Customer doesnt exist"));
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer existingCustomer = customerRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Customer doesnt exist"));

        existingCustomer.setName(customerDto.getName());
        existingCustomer.setAddress(customerDto.getAddress());
        existingCustomer.setPhone(customerDto.getPhone());
        existingCustomer.setEmail(customerDto.getEmail());

        customerRepository.save(existingCustomer);

        return customerToCustomerDto(existingCustomer);
    }
}
