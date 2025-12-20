package com.aja.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String fullName;

	private String password;

	private String confirmPassword;

	private String profileImage;

	private String photoUrl;

	private LocalDate dateOfBirth;

	private LocalDateTime createdAt = LocalDateTime.now();

	private String email;

	private String mobileNo;

	private IdentityProofType identityProofType;

	private String identityProofNumber;

//	Relationships

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Bookings> bookings = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Testimonials> testmonials = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Payments> payment = new ArrayList<>();

}
