package com.drive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DriveApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriveApplication.class, args);
	}
}
