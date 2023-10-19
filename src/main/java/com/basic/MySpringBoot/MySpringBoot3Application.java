package com.basic.MySpringBoot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringBoot3Application {

	public static void main(String[] args) {
		// SpringApplication.run(MySpringBoot3Application.class, args);
		SpringApplication application = new SpringApplication(MySpringBoot3Application.class);
		// 자동 이름 지어주기 ctrl+alt+v

		application.setWebApplicationType(WebApplicationType.SERVLET); // 아무것도 지정을 안하면 WebApplicationType.SERVLET
																	// WebApplicationType.NONE은 웹이 아니다! 톰캣도 기동 안 됨
		application.run(args);
	}

	@Bean //SpringBootApplication은 Config 역할도 하기 때문에  Bean 생성 가능
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	// MySpringBoot3Application 자체도 Configuration 역할을 하기 때문에 빈 등록 가능
//	@Bean
//	public String hello(){
//		return new String("Hello");
//	}
}
