package com.inventorysystem.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorysystem.springboot.model.Users;
import com.inventorysystem.springboot.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	UsersRepository usersRepository;
	
	public Optional<Users> validateUser(String username) {
		return usersRepository.findByUsername(username);
	}
}
