package com.aja.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Bookings{
	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public Integer getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(Integer noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public Integer getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(Integer noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
//	private HotelTypes hotelType;

    private LocalDate travelDate;

    private Integer noOfAdults;

    private Integer noOfChildren;

    private String bookingStatus;

    private LocalDateTime createdAt;
   
 // Many bookings -> one user
    
    @ManyToOne
    @JoinColumn(name = "user_id")
   private Users user;
    
    @ManyToOne
    @JoinColumn(name = "package_id")
    private Packages packages;
    
    
    @ManyToOne
    @JoinColumn(name = "hoteltype_id")
    private HotelTypes hoteltype;
    
    
    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private Payments payment;
    
    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private BookingPricing bookingpricing;

}
