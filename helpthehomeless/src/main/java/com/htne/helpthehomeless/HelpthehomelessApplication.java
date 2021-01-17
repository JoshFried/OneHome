package com.htne.helpthehomeless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HelpthehomelessApplication {

    public static void main(final String[] args) {
        SpringApplication.run(HelpthehomelessApplication.class, args);
    }

}
