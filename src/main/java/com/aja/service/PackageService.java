package com.aja.service;

import java.util.List;

import com.aja.entity.Packages;

public interface PackageService {
	public Packages addPackage(Packages p);
	public List<Packages> viewPackages();
	public Packages getPackage(Long packageId);
	public Packages updatePackage(Long packageId,Packages p);
}
