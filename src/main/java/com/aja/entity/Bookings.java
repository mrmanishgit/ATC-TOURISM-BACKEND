package com.aja.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class Bookings{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
//	private HotelTypes hotelType;

    private LocalDate travelDate;

    private Integer noOfAdults;

    private Integer noOfChildren;

    private String bookingStatus;

    private LocalDateTime createdAt;

}
