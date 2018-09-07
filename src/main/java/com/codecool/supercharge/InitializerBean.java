package com.codecool.supercharge;

import com.codecool.supercharge.model.Account;
import com.codecool.supercharge.model.Transaction;
import com.codecool.supercharge.model.User;
import com.codecool.supercharge.repository.AccountRepository;
import com.codecool.supercharge.repository.TransactionRepository;
import com.codecool.supercharge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class InitializerBean {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @PostConstruct
    public void populateDB(){
        User user1 = new User("Arlinda", "Aman");
        User user2 = new User("Polly", "Pinkerton");
        User user3 = new User("Audrea", "Anderson");
        User user4 = new User("Kacie", "Kirtley");
        User user5 = new User("Renda", "Rado");

        Account account1 = new Account(user1);
        Account account2 = new Account(user2);
        Account account3 = new Account(user3);
        Account account4 = new Account(user4);
        Account account5 = new Account(user5);

        Transaction transaction1 = new Transaction(account1, new Date(), "shopping", -2500);
        Transaction transaction2 = new Transaction(account1, new Date(), "pocket money", 5000);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        accountRepository.save(account1);
        accountRepository.save(account2);
        accountRepository.save(account3);
        accountRepository.save(account4);
        accountRepository.save(account5);

        transactionRepository.save(transaction1);
        transactionRepository.save(transaction2);
    }
}
