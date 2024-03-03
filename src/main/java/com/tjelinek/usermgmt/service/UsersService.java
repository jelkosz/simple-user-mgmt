package com.tjelinek.usermgmt.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tjelinek.usermgmt.dao.UserRepository;
import com.tjelinek.usermgmt.dto.User;
import com.tjelinek.usermgmt.exceptions.UsernameManipulationException;

@Service
@Transactional
public class UsersService {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;
	
	public UsersService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findById(UUID uuid) {
		return userRepository.findById(uuid);
	}

	public User createUser(User newUser) {
		ensureUniqueUsername(newUser, null);
		
		return userRepository.save(
				newUser
					.withId(null)
					.withPassword(passwordEncoder.encode(newUser.getPasswordInternal()))
				);
	}

	public Optional<User> updateUser(UUID uuid, User newUser) {
		ensureUniqueUsername(newUser, uuid);
		
		return userRepository.findById(uuid).map(user -> userRepository.save(user
					.withName(newUser.getName()))
					.withPassword(passwordEncoder.encode(newUser.getPasswordInternal()))
				);
	}

	public Optional<User> deleteUser(UUID uuid) {
		return userRepository.findById(uuid).map(user -> {
			userRepository.delete(user);
			return user;
		});
	}

	private void ensureUniqueUsername(User newUser, UUID uuid) {
		User dbUser = userRepository.findByUsername(newUser.getUsername());
		if (dbUser != null && !dbUser.getId().equals(uuid)) {
			throw new UsernameManipulationException("A user with this username already exists. Pleas pick a differen one.");	
		}
	}
}
