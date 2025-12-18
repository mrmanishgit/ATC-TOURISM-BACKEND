package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.entity.Users;
import com.aja.repository.UsersRepo;
import com.aja.service.UsersService;

@Service
public class UserServiceImpl implements UsersService{
	@Autowired
	private UsersRepo userRepository;
	  
    public UserServiceImpl(UsersRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users addUser(Users user) {

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new RuntimeException("Password and Confirm Password do not match");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        return userRepository.save(user);
        
    }

	@Override
	 public List<Users> getAllUsers() {
        return userRepository.findAll();
	}

	
	@Override
	public Users updateUser(Long id, Users user) {
		Users useren=userRepository.findById(id).orElse(null);
				
		useren.setFullName(user.getFullName());
		useren.setMobile(user.getMobile());
		useren.setIdentityProofType(user.getIdentityProofType());
		useren.setIdentityProofNumber(user.getIdentityProofNumber());
		useren.setProfileImage(user.getProfileImage());
		useren.setDob(user.getDob());
		useren.setEmail(user.getEmail());
		// TODO Auto-generated method stub
		return userRepository.save(useren);
	}
	
	@Override
	public Users login(String email, String password) {

	    Users user = userRepository.findByEmail(email);

	    if (user == null) {
	        throw new RuntimeException("Invalid email");
	    }

	    if (!user.getPassword().equals(password)) {
	        throw new RuntimeException("Invalid password");
	    }

	    return user;
	}

	@Override
	public Users registerUsers(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

}
