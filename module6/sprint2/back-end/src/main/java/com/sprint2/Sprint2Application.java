package com.sprint2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Sprint2Application {
//    @Bean
//    public ModelMapper modelMapper() {
//        return new ModelMapper();
//    }

    public static void main(String[] args) {
        SpringApplication.run(Sprint2Application.class, args);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("12345678"));
    }

}
