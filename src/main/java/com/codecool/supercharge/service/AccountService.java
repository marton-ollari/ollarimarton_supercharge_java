package com.codecool.supercharge.service;

import com.codecool.supercharge.model.Account;
import com.codecool.supercharge.model.User;
import com.codecool.supercharge.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public void saveAccount(Account account){
        accountRepository.save(account);
    }

    public Account getAccountByUser(User user){
        return accountRepository.findByUser(user);
    }

    public Account getAccountById(int id) {
        return accountRepository.findById(id);
    }
}
