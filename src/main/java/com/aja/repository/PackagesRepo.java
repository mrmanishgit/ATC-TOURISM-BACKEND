package com.aja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aja.entity.Packages;
@Repository
public interface PackagesRepo extends JpaRepository<Packages, Long> {

	List<Packages> findByIsFlagTrue();

	boolean existsByPackageNameIgnoreCase(String packageName);

}
