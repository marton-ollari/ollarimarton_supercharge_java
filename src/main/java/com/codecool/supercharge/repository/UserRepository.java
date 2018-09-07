package com.codecool.supercharge.repository;

import com.codecool.supercharge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User  findById(Integer id);
}
