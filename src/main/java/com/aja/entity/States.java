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
@Setter
@Getter
public class States {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;
	private String stateName;
>>>>>>> aadfddf802f8e13860d6df475837000ec472afe1

@Entity
public class States {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;
}
