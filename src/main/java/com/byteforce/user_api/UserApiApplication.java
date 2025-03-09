package com.byteforce.user_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class UserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

}
