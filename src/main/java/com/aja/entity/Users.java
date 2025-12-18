package com.aja.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Users{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId; 
	
	private String fullName; 
	
	private String password;
	
	@Column(unique=true)
	private String email;
	
	@NotBlank(message="Enter 10 digits mobile number")
	private String mobile;
	
	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	private IdentityProofType identityProofType;
	
	private String identityProofNumber;
	
	private String photoUrl;
	
	
//	Relationships
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Bookings> bookings = new ArrayList<>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Testimonials> testmonials = new ArrayList<>();
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public IdentityProofType getIdentityProofType() {
		return identityProofType;
	}

	public void setIdentityProofType(IdentityProofType identityProofType) {
		this.identityProofType = identityProofType;
	}

	public String getIdentityProofNumber() {
		return identityProofNumber;
	}

	public void setIdentityProofNumber(String identityProofNumber) {
		this.identityProofNumber = identityProofNumber;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public List<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}

	public List<Testimonials> getTestmonials() {
		return testmonials;
	}

	public void setTestmonials(List<Testimonials> testmonials) {
		this.testmonials = testmonials;
	}

	public List<Payments> getPayment() {
		return payment;
	}

	public void setPayment(List<Payments> payment) {
		this.payment = payment;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Payments> payment = new ArrayList<>();
	

	private String profileImage;
	@Column(nullable = false)
	

	private String confirmPassword;

	private LocalDate dob;

	private LocalDateTime createdAt = LocalDateTime.now();
}
