package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.entity.Enquiries;
import com.aja.repository.EnquiriesRepo;
import com.aja.service.EnquiriesService;

@Service
public class EnquiriesServiceImpl implements EnquiriesService {
	
	@Autowired
    private EnquiriesRepo enquiriesRepo;

	@Override
    public Enquiries saveEnquiry(Enquiries enquiry) {
        return enquiriesRepo.save(enquiry); 
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
