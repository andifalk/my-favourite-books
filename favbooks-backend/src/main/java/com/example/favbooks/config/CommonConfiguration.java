package com.example.favbooks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.IdGenerator;
import org.springframework.util.JdkIdGenerator;

/**
 * Configuration for common beans.
 */
@Configuration
public class CommonConfiguration {

    @Bean
    public IdGenerator idGenerator() {
        return new JdkIdGenerator();
    }
}
