package com.basic.MySpringBoot.config;

import com.basic.MySpringBoot.dto.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ProdConfig {

    @Bean
    public Customer customer(){
        return new Customer().builder() // CustomerBuilder라는 뜻
                .name("ProdConfig")
                .age(29).build();
    }
}
