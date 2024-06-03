package com.example.bankingsystem.service.impl;

import com.example.bankingsystem.dto.AccountDto;
import com.example.bankingsystem.dto.TransactionDto;
import com.example.bankingsystem.entity.Account;
import com.example.bankingsystem.repository.AccountRepository;
import com.example.bankingsystem.service.AccountService;
import com.example.bankingsystem.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    @Override
    public AccountDto accountToAccountDto(Account a) {
        return AccountDto.builder()
                .id(a.getId())
                .balance(a.getBalance())
                .customerId(a.getCustomer().getId())
                .transactions(a.getTransactions().stream()
                        .map(transactionService::transactionToTransactionDto)
                        .collect(Collectors.toSet()))
                .build();
    }
}
