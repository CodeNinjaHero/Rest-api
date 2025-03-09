package com.byteforce.user_api.presentation.controller;

import com.byteforce.user_api.application.dto.UserDTO;
import com.byteforce.user_api.application.service.UserService;
import com.byteforce.user_api.domain.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "Controller for managing users with CRUD operations")
public class UserController {

	private final UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@Operation(summary = "Find all users", description = "Retrieves a list of all registered users.")
	@ApiResponse(responseCode = "200", description = "List of users retrieved successfully")
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> users = service.findAll();
		return ResponseEntity.ok(users);
	}

	@Operation(summary = "Find user by ID", description = "Retrieves a user based on the provided ID.")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "User found successfully"),
		@ApiResponse(responseCode = "404", description = "User not found")
	})
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(
		@Parameter(description = "ID of the user to be retrieved", example = "1")
		@PathVariable Long id) {

		Optional<UserDTO> user = service.findById(id);
		return user.map(ResponseEntity::ok)
			.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@Operation(summary = "Create a new user", description = "Registers a new user in the system.")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "User created successfully"),
		@ApiResponse(responseCode = "400", description = "Invalid request data")
	})
	@PostMapping
	public ResponseEntity<UserDTO> save(
		@Parameter(description = "User data to be created")
		@RequestBody User user) {

		Optional<UserDTO> savedUser = service.save(user);
		return savedUser
			.map(userDto -> ResponseEntity.status(HttpStatus.CREATED).body(userDto))
			.orElseGet(() -> ResponseEntity.badRequest().build());
	}

	@Operation(
		summary = "Update an existing user",
		description = "Updates user data based on provided information. The user ID must be provided in the URL, not in the request body."
	)
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "User updated successfully"),
		@ApiResponse(responseCode = "400", description = "Invalid request: ID should not be present in request body"),
		@ApiResponse(responseCode = "404", description = "User not found")
	})
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(
		@Parameter(description = "ID of the user to be updated", example = "1")
		@PathVariable Long id,

		@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "User data to be updated (excluding ID)",
			required = true
		)
		@Valid @RequestBody User user) {
		if (user.getId() != null) {
			return ResponseEntity.badRequest().build();
		}

		Optional<UserDTO> updatedUser = service.update(id, user);
		return updatedUser.map(ResponseEntity::ok)
			.orElseGet(() -> ResponseEntity.notFound().build());
	}


	@Operation(summary = "Delete a user", description = "Removes a user from the system based on the provided ID.")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "User deleted successfully"),
		@ApiResponse(responseCode = "404", description = "User not found")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(
		@Parameter(description = "ID of the user to be deleted", example = "1")
		@PathVariable Long id) {

		boolean deleted = service.delete(id);
		return deleted ? ResponseEntity.noContent().build()
			: ResponseEntity.notFound().build();
	}
}
