package com.sjprogramming.restapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.sjprogramming.restapi.repository")
public class JpaConfig {
    // other configurations
}
