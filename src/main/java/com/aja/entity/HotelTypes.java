package com.aja.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HotelTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hotelTypeId;

	public Long getHotelTypeId() {
		return hotelTypeId;
	}

	public void setHotelTypeId(Long hotelTypeId) {
		this.hotelTypeId = hotelTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Double getPricePerday() {
		return pricePerday;
	}

	public void setPricePerday(Double pricePerday) {
		this.pricePerday = pricePerday;
	}

	public List<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}

	private String typeName;

	private Double pricePerday;
	
	@OneToMany(mappedBy = "hoteltype")
	private List<Bookings> bookings = new ArrayList<>();

}
