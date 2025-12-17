package com.aja.service;

import java.util.List;

import com.aja.entity.Users;

public interface UsersService {
	public Users addUser(Users u);
	public List<Users> viewAllUsers();
	public Users updateUser(Long userId,Users u);
	public Users deleteUser(Long userId);
}
