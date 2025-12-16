package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.States;

public interface StatesRepo extends JpaRepository<States, Long> {

}
