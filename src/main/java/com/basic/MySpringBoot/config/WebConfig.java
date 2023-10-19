package com.basic.MySpringBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
        // mobile하위의 프로젝트와의 통신을 위해서 작성
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**")
        //반드시 m 다음에 / 을 주어야 한다.
        .addResourceLocations("classpath:/mobile/")
        .setCachePeriod(20);//20초
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:18080")
                .allowedMethods("*");;
    }
}
