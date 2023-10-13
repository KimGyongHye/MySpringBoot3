package com.basic.MySpringBoot.repository;

import com.basic.MySpringBoot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // SELECT * FROM ACCOUNTS WWHERE USERNAME = 'SPRING';
    Optional<Account> findByUsername(String username);
}