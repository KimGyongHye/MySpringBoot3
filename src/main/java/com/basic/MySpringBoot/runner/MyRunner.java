package com.basic.MySpringBoot.runner;


import com.basic.MySpringBoot.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    private Customer customer;

    Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Override
    @Order(2)
    public void run(ApplicationArguments args) throws Exception {
        // ApplicationArguments args는 main문의 args가 넘어오는 것
        // args들을 넣어 준 뒤 실행
        logger.info("MyRunner");

        logger.info(logger.getClass().getName());         // ch.qos.logback.classic.Logger을 다른걸로 바꾸는 실습

        logger.debug("VM arguments foo : "+args.containsOption("foo"));
        logger.debug("Program arguments bar : "+args.containsOption("bar"));
        
        logger.info("----------------------------");
        logger.info("name : "+name);
        logger.info("age : "+age);
        logger.info("fullName : "+fullName);

       logger.debug("KGH : git 수정 파일 업로드");
       logger.debug("port number : "+environment.getProperty("local.server.port"));
       logger.debug("----------------------------");

       logger.info("customer"+customer);
    }
}
