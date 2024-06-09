package com.uep.wap.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class AppConfig {

    @Bean
    public User defaultUser(){
        return new User((long)1,"Jan", "skandal@malpa.gmail.com","Skunek","513143204","Wylewik123", LocalDateTime.now(),LocalDateTime.now());
    }

    }
