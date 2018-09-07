package com.codecool.supercharge.service;

import com.codecool.supercharge.model.Transaction;
import com.codecool.supercharge.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public void saveTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }
}
