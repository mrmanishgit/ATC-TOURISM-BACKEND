package com.aja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
=======
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Places {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long placeId;

	private String placeName;

	private String description;
>>>>>>> aadfddf802f8e13860d6df475837000ec472afe1

@Entity
public class Places {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeId;
}
