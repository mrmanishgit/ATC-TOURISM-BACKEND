package com.aja.service;

import java.util.List;

import com.aja.entity.Users;

public interface UsersService {
	
	 Users registerUsers(Users user);
	    List<Users> getAllUsers();
	    Users login(String email, String password);
	    Users updateUser(Long id, Users user);
	    Users addUser(Users user);


}
