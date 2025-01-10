package com.test.rgt_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class RgtTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(RgtTaskApplication.class, args);
	}

}
