package com.airgraft.services.apiaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.airgraft.services.apiaccess.config",
        "com.airgraft.services.apiaccess.controllers",
        "com.airgraft.services.apiaccess.repositories",
})
public class ApiAccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAccessApplication.class, args);
    }


}
