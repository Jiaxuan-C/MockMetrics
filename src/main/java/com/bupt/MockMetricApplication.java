package com.bupt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MockMetricApplication {
    public static void main(String[] args) {
        SpringApplication.run(MockMetricApplication.class, args);
    }
}
