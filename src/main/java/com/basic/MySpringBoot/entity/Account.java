package com.basic.MySpringBoot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Account {

    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false) // UNIQUE KEY
    private String username;
    @Column(nullable = false)  // NOT NULL
    private String password;
}