package com.aja.Dto;

import com.aja.entity.Meals;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelTypesRequestDto {

	private String htypeName;
	private Meals meals;
	private Double pricePerday;
}
