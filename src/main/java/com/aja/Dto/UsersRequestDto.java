package com.aja.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.aja.entity.IdentityProofType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersRequestDto {

	private String fullName;

	@Column(nullable = false)
	private String password;

	private String confirmPassword;

	private String profileImage;

	

	private LocalDate dateOfBirth;

	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(unique = true,nullable = false)
	private String email;

	@NotBlank(message = "Enter 10 digits mobile number")
	private String mobileNo;

	@Enumerated(EnumType.STRING)
	private IdentityProofType identityProofType;

	private String identityProofNumber;

}
