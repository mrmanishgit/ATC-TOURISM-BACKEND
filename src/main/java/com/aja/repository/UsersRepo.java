package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Long>{

}
