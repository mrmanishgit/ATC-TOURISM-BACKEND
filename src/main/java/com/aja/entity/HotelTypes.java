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
public class HotelTypes {
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

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long hotelTypeId;

	    private String typeName;

	    private Double pricePerday;

}
