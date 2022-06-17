package com.pashenko.ehop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EhopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EhopApplication.class, args);
    }

}
