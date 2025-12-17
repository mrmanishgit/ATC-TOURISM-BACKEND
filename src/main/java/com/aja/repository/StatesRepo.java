package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aja.entity.States;
@Repository
public interface StatesRepo extends JpaRepository<States, Long> {

}
