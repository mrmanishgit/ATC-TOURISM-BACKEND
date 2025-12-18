package com.aja.service;

import java.util.List;

import com.aja.Dto.EnquiriesRequestDto;
import com.aja.Dto.EnquiriesResponseDto;
import com.aja.entity.Enquiries;

public interface EnquiriesService {

	public EnquiriesResponseDto saveEnquiry(EnquiriesRequestDto enquiry);

	public List<Enquiries> getAllEnquiries();

	public Enquiries getEnquiryById(Long enquiryId);

}
