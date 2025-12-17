package com.aja.serviceImpl;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.entity.Users;
import com.aja.repository.UsersRepo;
import com.aja.service.UsersService;
@Service
public class UserServiceImpl implements UsersService {
	
	@Autowired
	UsersRepo userRepo;
	@Override
	public Users addUser(Users u) {
		// TODO Auto-generated method stub
		Users ur=userRepo.save(u);
		return ur;
	}
	@Override
	public List<Users> viewAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();	
	}
	@Override
	public Users updateUser(Long userId,Users u) {
		// TODO Auto-generated method stub
		
		Users ur=userRepo.findById(userId).orElse(null);
		ur.setPassword(u.getPassword());
		ur.setEmail(u.getEmail());
		ur.setMobile(u.getMobile());
		
		return userRepo.save(ur);
	}
	@Override
	public Users deleteUser(Long userId) {
		// TODO Auto-generated method stub
		Users u=userRepo.findById(userId).orElse(null);
		userRepo.deleteById(userId);
		return u;
	}
	
	

}
