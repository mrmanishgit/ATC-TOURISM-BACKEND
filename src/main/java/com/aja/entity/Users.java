package com.aja.entity;

import java.time.LocalDate;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@AllArgsConstructor
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
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Testimonials> testMonials;
	
}
