package com.basic.MySpringBoot.repository;

import com.basic.MySpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //Optional<User> findByName(String name);
    // Optional은 유니크일 때
    Optional<User> findByEmail(String email);

    List<User> findByName(String name);

}