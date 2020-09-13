package com.luckysix.luckysix_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LuckysixBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckysixBackendApplication.class, args);
    }

}
