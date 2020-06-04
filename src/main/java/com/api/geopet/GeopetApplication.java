package com.api.geopet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.api.geopet.model" })
@EnableJpaRepositories(basePackages = { "com.api.geopet.repository" })
public class GeopetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeopetApplication.class, args);
	}

}
