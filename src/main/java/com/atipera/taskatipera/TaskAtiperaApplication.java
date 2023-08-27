package com.atipera.taskatipera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TaskAtiperaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskAtiperaApplication.class, args);
    }

}
