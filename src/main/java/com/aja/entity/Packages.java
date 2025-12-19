package com.aja.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	private boolean isFlag = true;

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Integer getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(Integer durationDays) {
		this.durationDays = durationDays;
	}

	public Double getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(Double adultPrice) {
		this.adultPrice = adultPrice;
	}

	public Double getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(Double childPrice) {
		this.childPrice = childPrice;
	}

	public Double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public Double getPickupPrice() {
		return pickupPrice;
	}

	public void setPickupPrice(Double pickupPrice) {
		this.pickupPrice = pickupPrice;
	}

	public Double getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(Double gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public List<Bookings> getBooking() {
		return booking;
	}

	public void setBooking(List<Bookings> booking) {
		this.booking = booking;
	}

	public List<Testimonials> getTestimonial() {
		return testimonial;
	}

	public void setTestimonial(List<Testimonials> testimonial) {
		this.testimonial = testimonial;
	}

	public List<PackageLocations> getPackagelocations() {
		return packagelocations;
	}

	public void setPackagelocations(List<PackageLocations> packagelocations) {
		this.packagelocations = packagelocations;
	}

	private Double pickupPrice;

	private Double gstPercentage;

//	Relationships

	@ManyToOne
	@JoinColumn(name = "state_id")
	private States state;

	@OneToMany(mappedBy = "packages")
	private List<Bookings> booking = new ArrayList<>();

	@OneToMany(mappedBy = "packages")
	private List<Testimonials> testimonial = new ArrayList<>();

	@OneToMany(mappedBy = "packages")
	private List<PackageLocations> packagelocations = new ArrayList<>();
}
