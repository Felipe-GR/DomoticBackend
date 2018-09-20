package com.example.domotic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DomoticApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomoticApplication.class, args);
	}
}
