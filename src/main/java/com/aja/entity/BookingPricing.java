package com.aja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD

@Entity
public class BookingPricing {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
=======
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
>>>>>>> aadfddf802f8e13860d6df475837000ec472afe1
}
