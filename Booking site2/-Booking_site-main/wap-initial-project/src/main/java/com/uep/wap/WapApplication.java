package com.uep.wap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WapApplication {
    public static void main(String[] args) {
        SpringApplication.run(WapApplication.class, args);
    }
}
