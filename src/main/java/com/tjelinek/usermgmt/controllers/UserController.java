package com.tjelinek.usermgmt.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tjelinek.usermgmt.dto.User;
import com.tjelinek.usermgmt.service.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController extends BaseUserController {

	private final UsersService userService;

	public UserController(UsersService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public Iterable<User> listUsers() {
		return userService.findAll();
	}

	@PostMapping
	public User createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<User> getUser(@PathVariable UUID uuid) {
		return handleNotFoundResponse(uuid, () -> userService.findById(uuid));
	}

	@PutMapping("/{uuid}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable UUID uuid) {
		return handleNotFoundResponse(uuid, () -> userService.updateUser(uuid, user));
	}

}
