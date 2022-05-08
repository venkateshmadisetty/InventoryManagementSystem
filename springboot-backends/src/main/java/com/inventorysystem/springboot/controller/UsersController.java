package com.inventorysystem.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventorysystem.springboot.exception.ResourceNotFoundException;
import com.inventorysystem.springboot.model.Users;
import com.inventorysystem.springboot.repository.UsersRepository;
import com.inventorysystem.springboot.service.UserService;

//@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
public class UsersController {

	private static final Logger log = LoggerFactory.getLogger(UsersController.class);
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserService userService;
	
	// get all Users
	@GetMapping("/Users")
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}		


	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/users")
	public Users createusers(@RequestBody Users users) {
		log.info("inside registration****************");
		return usersRepository.save(users);
	}
	
	// get users by id rest api
	@GetMapping("/Users/{id}")
	public ResponseEntity<Users> getusersById(@PathVariable Long id) {
		Users users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("users not exist with id :" + id));
		return ResponseEntity.ok(users);
	}
	
	// update users rest api
	
	@PutMapping("/Users/{id}")
	public ResponseEntity<Users> usersusers(@PathVariable Long id, @RequestBody Users usersDetails){
		Users users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("users not exist with id :" + id));
		
		users.setName(usersDetails.getName());
		users.setUsername(usersDetails.getUsername());
		users.setPassword(usersDetails.getPassword());
		
	
		Users updatedusers = usersRepository.save(users);
		return ResponseEntity.ok(updatedusers);
	}
	
	// delete users rest api
	@DeleteMapping("/Users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteusers(@PathVariable Long id){
		Users users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("users not exist with id :" + id));
		
		usersRepository.delete(users);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/users/login")
	public ResponseEntity<Users> login(@RequestBody Users user){
		Optional<Users> userOptional = userService.validateUser(user.getUsername());
		if(userOptional.isPresent()) {
			Users users = usersRepository.findById(userOptional.get().getId()).get();
			if(users.getPassword().equals(user.getPassword()))
				return new ResponseEntity<Users>(users, HttpStatus.OK);
			else
				return new ResponseEntity<Users>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Users>(HttpStatus.BAD_REQUEST);	
	}
	
}

	
