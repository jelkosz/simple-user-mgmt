package com.tjelinek.usermgmt.dto;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity(name = "users")
public class User {

	@Id
	@UuidGenerator
	private UUID id;

	@NotEmpty(message = "Name must not be empty")
	@Size(max = 255, message = "The name cant be longer than 255 characters")
	private String name;
	
	@NotEmpty(message = "UserName must not be empty")
	@Size(max = 255, message = "The username cant be longer than 255 characters")
	private String username;
	
	@NotEmpty(message = "Password must not be empty")
	@Size(max = 255, message = "The password cant be longer than 255 characters")
	private String password;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		// never return password to the client
		return "";
	}
	
	@JsonIgnore
	public String getPasswordInternal() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User withName(String name) {
		setName(name);
		return this;
	}
	
	public User withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public User withId(UUID id) {
		this.id = id;
		return this;
	}
}
