package com.example.bankingsystem.service;

import com.example.bankingsystem.dto.CustomerDto;
import com.example.bankingsystem.entity.Customer;

public interface CustomerService {
    public CustomerDto customerToCustomerDto(Customer c);
    public Customer detailedCustomerToCustomerDto(CustomerDto c);
    public String createCustomer(CustomerDto customer);
}
