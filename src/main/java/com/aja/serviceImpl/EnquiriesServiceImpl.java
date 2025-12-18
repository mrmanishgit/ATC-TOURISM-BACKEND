package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.EnquiriesRequestDto;
import com.aja.Dto.EnquiriesResponseDto;
import com.aja.entity.Enquiries;
import com.aja.repository.EnquiriesRepo;
import com.aja.service.EnquiriesService;

@Service
public class EnquiriesServiceImpl implements EnquiriesService {

	@Autowired
	private EnquiriesRepo enquiriesRepo;

	@Override
	public EnquiriesResponseDto saveEnquiry(EnquiriesRequestDto pdto) {
		Enquiries en = new Enquiries();
		BeanUtils.copyProperties(pdto, en);
		Enquiries saveEnt = enquiriesRepo.save(en);
		EnquiriesResponseDto enrd = new EnquiriesResponseDto();
		BeanUtils.copyProperties(saveEnt, enrd);
		return enrd;

	}

	@Override
	public List<Enquiries> getAllEnquiries() {
		// TODO Auto-generated method stub
		return enquiriesRepo.findAll();
	}

	@Override
	public Enquiries getEnquiryById(Long enquiryId) {
		// TODO Auto-generated method stub
		return enquiriesRepo.findById(enquiryId).orElse(null);
	}

}
