package com.example.bankingsystem.service.impl;

import com.example.bankingsystem.dto.TransactionDto;
import com.example.bankingsystem.entity.Transaction;
import com.example.bankingsystem.repository.TransactionRepository;
import com.example.bankingsystem.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public TransactionDto transactionToTransactionDto(Transaction t) {
        return TransactionDto.builder()
                .id(t.getId())
                .amount(t.getAmount())
                .date(t.getDate())
                .accountId(t.getAccount().getId())
                .build();
    }
}
