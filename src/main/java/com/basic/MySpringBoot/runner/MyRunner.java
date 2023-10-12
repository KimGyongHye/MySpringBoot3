package com.basic.MySpringBoot.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Order(1)  // 우선순위를 줄 수 있는 것
public class MyRunner implements ApplicationRunner {
    @Value("${myboot.name}")
    private String name;
    @Value("${myboot.age}")
    private int age;
    @Value("${myboot.fullName}")
    private String fullName;

    @Autowired
    private Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // ApplicationArguments args는 main문의 args가 넘어오는 것
        // args들을 넣어 준 뒤 실행
        System.out.println("MyRunner");
        System.out.println("VM arguments foo : "+args.containsOption("foo"));
        System.out.println("Program arguments bar : "+args.containsOption("bar"));

        System.out.println("----------------------------");
        System.out.println("name : "+name);
        System.out.println("age : "+age);
        System.out.println("fullName : "+fullName);

        System.out.println("port number : "+environment.getProperty("local.server.port"));

    }
}
