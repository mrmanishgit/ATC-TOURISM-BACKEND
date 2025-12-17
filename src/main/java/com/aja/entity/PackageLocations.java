package com.aja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD

@Entity
public class PackageLocations {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageLocId;
=======
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PackageLocations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
>>>>>>> aadfddf802f8e13860d6df475837000ec472afe1
}
