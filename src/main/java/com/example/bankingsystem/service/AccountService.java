package com.example.bankingsystem.service;

import com.example.bankingsystem.dto.AccountDto;
import com.example.bankingsystem.dto.TransactionDto;
import com.example.bankingsystem.entity.Account;

public interface AccountService {
    public AccountDto accountToAccountDto(Account a);
}
