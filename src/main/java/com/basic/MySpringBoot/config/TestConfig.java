package com.basic.MySpringBoot.config;

import com.basic.MySpringBoot.dto.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfig {

    @Bean
    public Customer customer(){
        return new Customer().builder() // CustomerBuilder라는 뜻
                .name("TestConfig")
                .age(29).build();
    }
}
