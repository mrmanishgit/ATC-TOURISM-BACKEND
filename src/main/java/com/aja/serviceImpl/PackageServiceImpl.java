package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.entity.Packages;
import com.aja.repository.PackagesRepo;
import com.aja.service.PackageService;
@Service
public class PackageServiceImpl implements PackageService {
	@Autowired
	private PackagesRepo pRepo;
	@Override
	public Packages addPackage(Packages p) {
		// TODO Auto-generated method stub
		Packages ps=pRepo.save(p);
		return ps;
	}

	@Override
	public List<Packages> viewPackages() {
		// TODO Auto-generated method stub
		
		return pRepo.findAll();
	}

	@Override
	public Packages updatePackage(Long packageId, Packages p) {
		// TODO Auto-generated method stub
		Packages ps=pRepo.findById(packageId).orElse(null);
		ps.setPackageName(p.getPackageName());
		ps.setGstPercentage(p.getGstPercentage());
		ps.setDurationDays(p.getDurationDays());
		ps.setAdultPrice(p.getAdultPrice());
		ps.setChildPrice(p.getChildPrice());
		ps.setFoodPrice(p.getFoodPrice());
		return ps;
	}

	@Override
	public Packages getPackage(Long packageId) {
		// TODO Auto-generated method stub
		return pRepo.findById(packageId).orElse(null);
	}

}
