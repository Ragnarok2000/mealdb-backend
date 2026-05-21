package com.example.FinFactor.MealDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MealDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealDbApplication.class, args);
	}

}
