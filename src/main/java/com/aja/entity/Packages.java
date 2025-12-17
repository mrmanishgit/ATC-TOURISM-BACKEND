package com.aja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Packages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long packageId;

	private String packageName;

	private Integer durationDays;

	private Double adultPrice;

	private Double childPrice;

	private Double foodPrice;

	private Double pickupPrice;

	private Double gstPercentage;
}
