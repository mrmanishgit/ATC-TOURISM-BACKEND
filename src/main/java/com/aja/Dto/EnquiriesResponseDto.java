package com.aja.Dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnquiriesResponseDto {

	private String name;

	private String email;

	private Long mobileNo;

	private String message;

	private LocalDateTime createdAt = LocalDateTime.now();
}
