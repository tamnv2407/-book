package com.books.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.books.model.User;
import com.books.model.UserDTO;
import com.books.repository.UserRepository;
import com.books.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	public User login(UserDTO userDTO) {
		User user = userRepository.getUserByEmail(userDTO.getEmail());

		if (user != null && user.getPassword() != null
				&& encoder.matches(userDTO.getPassword(), user.getPassword())) {
			return user;
		}

		return null;
	}

}
