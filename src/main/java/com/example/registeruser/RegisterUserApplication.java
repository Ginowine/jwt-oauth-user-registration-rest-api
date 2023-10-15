package com.example.registeruser;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User Registration and CRUD API", version = "1.0", description = "User Registration and CRUD APIs"))
public class RegisterUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterUserApplication.class, args);
	}

}
