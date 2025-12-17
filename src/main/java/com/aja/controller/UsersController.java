package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.entity.Users;
import com.aja.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UserServiceImpl userImpl;
	
	@PostMapping
	public Users addUser(@RequestBody Users u)
	{
		return userImpl.addUser(u);
	}
	@GetMapping
	public List<Users> viewAllUsers()
	{
		return userImpl.viewAllUsers();
	}
	@PutMapping("/update/{userId}")
	public Users updateUser(@PathVariable Long userId,@RequestBody Users u)
	{
		return userImpl.updateUser(userId, u);
	}
	@DeleteMapping("/delete/{userId}")
	public Users deleteUser(@PathVariable Long userId)
	{
		return userImpl.deleteUser(userId);
	}
}
