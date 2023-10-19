package com.basic.MySpringBoot.security.repository;

import com.basic.MySpringBoot.security.entity.UserInfo;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserInfoRepository extends ListCrudRepository<UserInfo, Integer> {
    Optional<UserInfo> findByEmail(String email);
}