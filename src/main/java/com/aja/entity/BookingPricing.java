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
public class BookingPricing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pricingId;
	
	private Double adultTotal;

	private Double childTotal;

	private Double foodTotal;

	private Double pickupTotal;

	private Double gstAmount;

	private Double finalAmount;

}
