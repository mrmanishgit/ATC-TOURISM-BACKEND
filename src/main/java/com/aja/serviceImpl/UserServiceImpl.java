package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.UsersRequestDto;
import com.aja.Dto.UsersResponseDto;
import com.aja.entity.Users;
import com.aja.repository.UsersRepo;
import com.aja.service.UsersService;

@Service
public class UserServiceImpl implements UsersService {
	@Autowired
	private UsersRepo userRepository;

//	1
	@Override
	public UsersResponseDto registerUsers(UsersRequestDto user) {

		if (!user.getPassword().equals(user.getConfirmPassword())) {
			throw new RuntimeException("Password and Confirm Password do not match");
		}

		if (userRepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("Email already registered");
		}
//		
		Users users = new Users();
//		
//		user-->users(entity)
		BeanUtils.copyProperties(user, users);

//		 p.setFlag(true); // for soft delete

		Users entity = userRepository.save(users);
//		
		UsersResponseDto userRes = new UsersResponseDto();

//		users-->userRes
		BeanUtils.copyProperties(entity, userRes);

//		return userRepository.save(user);
		return userRes;

	}

//	2
	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

//	3
	@Override
	public Users updateUser(Long id, Users user) {
		Users useren = userRepository.findById(id).orElse(null);

		useren.setFullName(user.getFullName());
		useren.setMobileNo(user.getMobileNo());
		useren.setIdentityProofType(user.getIdentityProofType());
		useren.setIdentityProofNumber(user.getIdentityProofNumber());
		useren.setProfileImage(user.getProfileImage());
		useren.setDateOfBirth(user.getDateOfBirth());
		useren.setEmail(user.getEmail());
		// TODO Auto-generated method stub
		return userRepository.save(useren);
	}

//	4
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

}
