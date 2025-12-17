package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.Packages;

public interface PackagesRepo extends JpaRepository<Packages, Long> {

}
