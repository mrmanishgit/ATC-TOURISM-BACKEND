package com.aja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PackageLocations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;

//	Relationships

	@ManyToOne
	@JoinColumn(name = "place_id")
	private Places place;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Places getPlace() {
		return place;
	}

	public void setPlace(Places place) {
		this.place = place;
	}

	public Packages getPackages() {
		return packages;
	}

	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	@ManyToOne
	@JoinColumn(name = "package_id")
	private Packages packages;
}
