package com.souljit2.selleverything;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@EnableTransactionManagement
@SpringBootApplication
public class SellEverythingApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellEverythingApplication.class, args);
    }

}
