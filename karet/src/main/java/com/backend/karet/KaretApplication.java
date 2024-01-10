package com.backend.karet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.backend.karet")
@ComponentScan(basePackages = "com.backend")
public class KaretApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaretApplication.class, args);
	}

}
