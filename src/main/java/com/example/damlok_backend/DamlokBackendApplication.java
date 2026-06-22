package com.example.damlok_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DamlokBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DamlokBackendApplication.class, args);
	}

}
