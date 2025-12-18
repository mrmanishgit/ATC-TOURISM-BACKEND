package com.aja.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class TestimonialsRequestDto {
	
	private Long testId;
	private String name;
	private String rating;
	private String review;
	private String image;
}
