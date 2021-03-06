package com.mifeb.mifebrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.mifeb.meetupmodel.entity")
@EnableJpaRepositories("com.mifeb.meetupmodel.entity")
@ComponentScan({"com.mifeb"})
@SpringBootApplication
public class SpringBootConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }
}