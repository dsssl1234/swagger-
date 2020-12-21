package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync//开启异步任务
@EnableScheduling//开启定时任务
@SpringBootApplication
public class SpringbootSwagger20201220Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwagger20201220Application.class, args);
    }

}
