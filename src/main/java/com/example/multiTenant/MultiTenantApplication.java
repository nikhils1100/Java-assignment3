package com.example.multiTenant;

import controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = BookController.class)
public class MultiTenantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiTenantApplication.class, args);


	}

}
