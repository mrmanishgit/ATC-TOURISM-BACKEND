package com.aja.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.PackagesRequestDto;
import com.aja.Dto.PackagesResponseDto;
import com.aja.entity.Packages;
import com.aja.repository.PackagesRepo;
import com.aja.service.PackageService;
@Service
public class PackageServiceImpl implements PackageService {
	@Autowired
	private PackagesRepo pRepo;
	@Override
	public PackagesResponseDto addPackage(PackagesRequestDto p) {
		Packages packages = new Packages();
		
		BeanUtils.copyProperties(p, packages);
		
		Packages packEntity = pRepo.save(packages);
		
		PackagesResponseDto packRes = new PackagesResponseDto();
		
		BeanUtils.copyProperties(packEntity, packRes);
		
		return packRes;
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
		return null;
	}

	@Override
	public String deletePackage(Long id) {
		// TODO Auto-generated method stub
	Optional<Packages> delbyId = pRepo.findById(id);
	
	Packages obj = null;
	if(delbyId.isPresent()) {
		obj = delbyId.get();
		obj.setFlag(false);
	      pRepo.save(obj);
	      }
	
	if(obj!=null) {
		return "Package Deleted Successfully";
	}
	else {
		return "Package is not deleted";
	}
	
	
	
	
	
	}
	


	



}
