package com.sjprogramming.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.sjprogramming.restapi.entity")
public class SpringBootRestApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiProjectApplication.class, args);
	}
}
