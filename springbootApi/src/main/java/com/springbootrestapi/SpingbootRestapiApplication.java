package com.springbootrestapi;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@SpringBootApplication
@EntityScan(basePackages = "com.springbootrestapi.entity")

public class SpingbootRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingbootRestapiApplication.class, args);
	}

}
