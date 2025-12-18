package com.aja.service;

import java.util.List;

import com.aja.Dto.EnquiriesRequestDto;
import com.aja.Dto.EnquiriesResponseDto;
import com.aja.entity.Enquiries;

public interface EnquiriesService {

<<<<<<< Updated upstream
	Enquiries saveEnquiry(Enquiries enquiry);
=======
	public EnquiriesResponseDto saveEnquiry(EnquiriesRequestDto enquiry);
>>>>>>> Stashed changes

	List<Enquiries> getAllEnquiries();

	Enquiries getEnquiryById(Long enquiryId);

}
