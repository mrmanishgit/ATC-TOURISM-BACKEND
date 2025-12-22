package com.aja.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TestimonialsResponseDto {
	private String name;
	private Integer rating;
	private String review;
	private String image;
}
