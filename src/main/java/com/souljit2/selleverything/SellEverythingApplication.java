package com.souljit2.selleverything;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SellEverythingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellEverythingApplication.class, args);
    }

}
