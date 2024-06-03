package com.example.bankingsystem.service;

import com.example.bankingsystem.dto.CustomerDto;
import com.example.bankingsystem.entity.Customer;

import java.util.List;

public interface CustomerService {
    public CustomerDto customerToCustomerDto(Customer c);
    public Customer detailedCustomerToCustomerDto(CustomerDto c);
    public String createCustomer(CustomerDto customer);
    public List<CustomerDto> getAllCustomers();
    public CustomerDto getCustomerById(Long id);
    public void deleteCustomer(Long id);
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto);
}
