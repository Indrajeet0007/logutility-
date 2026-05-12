package com.EXTRAJEET;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
public class LogUtilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogUtilityApplication.class, args);
	}

}
