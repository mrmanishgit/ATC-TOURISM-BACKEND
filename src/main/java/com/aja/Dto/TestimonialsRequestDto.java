package com.aja.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TestimonialsRequestDto {
	

	private String name;
	private Integer rating;
	private String review;
	private String image;
}
