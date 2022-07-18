package com.demo.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@EnableJdbcRepositories("com.demo.projects.repository")
@SpringBootApplication
public class PokemonManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonManagerApplication.class, args);
	}

}
