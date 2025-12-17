package com.aja.entity;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enquiries {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
=======
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Enquiries {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enquiryId;

	private String name;

	private String email;

	private Long mobileNo;

	private String message;

	private LocalDateTime createdAt;
>>>>>>> aadfddf802f8e13860d6df475837000ec472afe1
}
