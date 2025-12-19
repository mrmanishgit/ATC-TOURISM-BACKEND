package com.aja.service;

import java.util.List;

import com.aja.Dto.PackagesRequestDto;
import com.aja.Dto.PackagesResponseDto;
import com.aja.entity.Packages;

public interface PackageService {
	public PackagesResponseDto addPackage(PackagesRequestDto p);

	public List<Packages> viewPackages();

	public Packages getPackage(Long packageId);

	public Packages updatePackage(Long packageId, Packages p);

	public String deletePackage(Long id);
}
