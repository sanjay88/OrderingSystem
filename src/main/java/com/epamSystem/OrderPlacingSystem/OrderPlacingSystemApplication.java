package com.epamSystem.OrderPlacingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OrderPlacingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderPlacingSystemApplication.class, args);
	}

}
