package com.basic.MySpringBoot.dto;

import lombok.*;

@NoArgsConstructor
// 디폴트 생성자
@AllArgsConstructor
// 모든 매개변수있는 생성자
@Getter
@Setter
@ToString
@Builder
/*
빌더 패턴
    Bag bag = Bag.builder()
            .name("name")
                .money(1000)
                .memo("memo")
                .build();같이 하는 것
    생성자에 설정해야하는 먀개변수들이 많을 때 생성
    생성자에 있는 모든 생성자들을 넣지 않아도 됨
*/
public class Customer {
    private String name;
    private int age;
}