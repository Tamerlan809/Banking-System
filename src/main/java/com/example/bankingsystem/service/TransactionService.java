package com.example.bankingsystem.service;

import com.example.bankingsystem.dto.TransactionDto;
import com.example.bankingsystem.entity.Transaction;

public interface TransactionService {
    public TransactionDto transactionToTransactionDto(Transaction t);
}
