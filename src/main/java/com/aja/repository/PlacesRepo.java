package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.Places;

public interface PlacesRepo extends JpaRepository<Places, Long> {

}
