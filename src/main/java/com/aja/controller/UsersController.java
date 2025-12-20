package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.UsersRequestDto;
import com.aja.Dto.UsersResponseDto;
import com.aja.entity.Users;
import com.aja.serviceImpl.UserServiceImpl;

@RestController

@RequestMapping("/api/users")
@CrossOrigin("*")
public class UsersController {

	@Autowired
	private UserServiceImpl userImpl;

	@PostMapping("/add")
//	public Users getUser(@RequestBody Users u)
//
//	//@PostMapping()
	
	public ResponseEntity<UsersResponseDto> getUser(@RequestBody UsersRequestDto u)

	{

		UsersResponseDto uRes = userImpl.registerUsers(u);

		return ResponseEntity.ok(uRes);
	}

	@GetMapping("/all")
	public List<Users> getAllUsers() {
		return userImpl.getAllUsers();

	}

	@PutMapping("/update/{id}")
	public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
		return userImpl.updateUser(id, user);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UsersRequestDto request) {
		try {
			Users user = userImpl.login(request.getEmail(), request.getPassword());
			return ResponseEntity.ok(user);
		} catch (RuntimeException ex) {
			return ResponseEntity.status(401).body(ex.getMessage());
		}
	}
}
