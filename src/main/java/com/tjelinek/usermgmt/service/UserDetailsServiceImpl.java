package com.tjelinek.usermgmt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tjelinek.usermgmt.dao.UserRepository;
import com.tjelinek.usermgmt.dto.User;
import com.tjelinek.usermgmt.dto.UserDetailsDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			return new UserDetailsDao(user);
		}

		throw new UsernameNotFoundException("User with name " + username + " can not be found");
	}
}
