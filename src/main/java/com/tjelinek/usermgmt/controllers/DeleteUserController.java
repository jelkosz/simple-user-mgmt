package com.tjelinek.usermgmt.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tjelinek.usermgmt.dto.User;
import com.tjelinek.usermgmt.service.UsersService;

@RestController
@RequestMapping("/users-protected")
public class DeleteUserController extends BaseUserController {

	private final UsersService userService;
	
	public DeleteUserController(UsersService userService) {
		super();
		this.userService = userService;
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<User> deleteUser(@PathVariable  UUID uuid) {
		return handleNotFoundResponse(uuid, () -> userService.deleteUser(uuid));
	}
}
