package com.codecool.supercharge.repository;

import com.codecool.supercharge.model.Account;
import com.codecool.supercharge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUser(User user);
}
