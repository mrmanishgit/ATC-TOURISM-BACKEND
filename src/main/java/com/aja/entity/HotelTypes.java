package com.aja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HotelTypes {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bhotelTypeId;
}
