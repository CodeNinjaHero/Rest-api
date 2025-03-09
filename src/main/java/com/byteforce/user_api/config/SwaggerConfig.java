package com.byteforce.user_api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
	info = @Info(
		title = "User API",
		description = "This is a REST API for interacting with users",
		termsOfService = "https://www.byteforce.com/terms",
		version = "1.0.0",
		contact = @Contact(
			name = "ByteForce Team",
			url = "https://byteforce.com/contact",
			email = "support@byteforce.com"
		),
		license = @License(
			name = "API License",
			url = "https://www.byteforce.com/license"
		)
	),
	servers = {
		@Server(
			description = "DEV SERVER",
			url = "http://localhost:6969/api"
		),
		@Server(
			description = "PROD SERVER",
			url = "http://byteforce:8080/api"
		)
	}
)
public class SwaggerConfig {
}
