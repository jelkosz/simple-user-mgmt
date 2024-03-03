package com.tjelinek.usermgmt.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.tjelinek.usermgmt.dto.User;

public interface UserRepository extends CrudRepository<User, UUID> {

	User findByUsername(String username);

}
