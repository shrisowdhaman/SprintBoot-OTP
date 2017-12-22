package com.shri.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.shri.repo")
@EntityScan("com.shri.model")
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})//bypass this spring boot security mechanism.
@SpringBootApplication(scanBasePackages = {"com.shri"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
