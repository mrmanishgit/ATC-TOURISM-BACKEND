package com.aja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity

public class Places {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long placeId;

	private String placeName;

	private String description;
}



