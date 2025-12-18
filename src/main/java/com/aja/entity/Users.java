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
public class Users{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId; 
	
	private String fullName; 
	
	private String password;
	
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Bookings> bookings = new ArrayList<>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Testimonials> testmonials = new ArrayList<>();
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Payments> payment = new ArrayList<>();
	
}
