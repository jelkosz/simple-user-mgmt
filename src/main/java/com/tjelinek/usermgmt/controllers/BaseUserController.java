package com.tjelinek.usermgmt.controllers;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import com.tjelinek.usermgmt.dto.User;

public abstract class BaseUserController {
	
	protected ResponseEntity<User> handleNotFoundResponse(UUID uuid, Supplier<Optional<User>> responseSupplier) {
		return ResponseEntity.ok(responseSupplier.get().orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Can not find user with id " + uuid)));
	}
}
