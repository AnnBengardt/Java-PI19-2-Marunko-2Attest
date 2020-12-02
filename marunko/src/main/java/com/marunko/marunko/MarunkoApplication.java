package com.marunko.marunko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MarunkoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarunkoApplication.class, args);
    }

}
