package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.PackageDeleteResponseDto;
import com.aja.Dto.PackagesRequestDto;
import com.aja.Dto.PackagesResponseDto;
import com.aja.entity.Packages;
import com.aja.entity.States;
import com.aja.exceptions.PackageNotFoundException;
import com.aja.repository.PackagesRepo;
import com.aja.repository.StatesRepo;
import com.aja.service.PackageService;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	private PackagesRepo pRepo;
	
	@Autowired
	private StatesRepo sRepo;

    @Autowired
    private StatesRepo statesRepo;

	    Packages pack = new Packages();

	    // ✅ Copies simple fields INCLUDING imageUrl
	    BeanUtils.copyProperties(p, pack);

	    // ✅ Manually map stateId → State entity
	    if (p.getStateId() != null) {
	        States state = sRepo.findById(p.getStateId())
	            .orElseThrow(() -> new RuntimeException("State not found"));
	        pack.setState(state);
	    }

	    Packages entity = pRepo.save(pack);

	    PackagesResponseDto pRes = new PackagesResponseDto();
	    BeanUtils.copyProperties(entity, pRes);

	    return pRes;
	}

        return res;
    }

		List<Packages> viewAllPackages = pRepo.findByIsFlagTrue();

        List<Packages> packagesList = packagesRepo.findByIsFlagTrue();
        List<PackagesResponseDto> responseList = new ArrayList<>();

        for (Packages pack : packagesList) {
            PackagesResponseDto dto = new PackagesResponseDto();
            BeanUtils.copyProperties(pack, dto);
            responseList.add(dto);
        }

        return responseList;
    }

    // GET PACKAGE BY ID
    @Override
    public PackagesResponseDto getPackage(Long packageId) {

        Packages pack = packagesRepo.findById(packageId)
                .orElseThrow(() ->
                        new PackageNotFoundException(
                                "Package not found with id: " + packageId));

        PackagesResponseDto dto = new PackagesResponseDto();
        BeanUtils.copyProperties(pack, dto);

        return dto;
    }

    // UPDATE PACKAGE
    @Override
    public PackagesResponseDto updatePackage(Long packageId, PackagesRequestDto dto) {

        Packages pack = packagesRepo.findById(packageId)
                .orElseThrow(() ->
                        new PackageNotFoundException(
                                "Cannot update. Package not found"));

        pack.setPackageName(dto.getPackageName());
        pack.setDurationDays(dto.getDurationDays());
        pack.setAdultPrice(dto.getAdultPrice());
        pack.setChildPrice(dto.getChildPrice());
        pack.setFoodPrice(dto.getFoodPrice());
        pack.setPickupPrice(dto.getPickupPrice());
        pack.setGstPercentage(dto.getGstPercentage());

        Packages updated = packagesRepo.save(pack);

        PackagesResponseDto res = new PackagesResponseDto();
        BeanUtils.copyProperties(updated, res);

        return res;
    }

    // SOFT DELETE PACKAGE
    @Override
    public PackageDeleteResponseDto deletePackage(Long id) {

        Packages pack = packagesRepo.findById(id)
                .orElseThrow(() ->
                        new PackageNotFoundException(
                                "Cannot delete. Package not found"));

        pack.setFlag(false);
        packagesRepo.save(pack);

        PackageDeleteResponseDto res = new PackageDeleteResponseDto();
        res.setDeleted(true);
        res.setMessage("Package deleted successfully");

        return res;
    }
}
