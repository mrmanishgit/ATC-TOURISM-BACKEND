package com.aja.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId; // PK
	private String userName;
	private String email;
	private String password;
	private Long mobileNo;
	private Long aadhaarNo;
	private Long passportNo;
	private String role; // admin or user
	private LocalDate createdAt;
}
