package com.aja.service;

import java.util.List;

import com.aja.Dto.UsersRequestDto;
import com.aja.Dto.UsersResponseDto;
import com.aja.entity.Users;

public interface UsersService {	   

	public UsersResponseDto registerUsers(UsersRequestDto user);


	public List<Users> getAllUsers();

	public Users login(String email, String password);

	public Users updateUser(Long id, Users user);



}
