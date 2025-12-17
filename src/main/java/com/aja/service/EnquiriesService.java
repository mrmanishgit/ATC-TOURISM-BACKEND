package com.aja.service;

import java.util.List;

import com.aja.entity.Enquiries;

public interface EnquiriesService {

	Enquiries saveEnquiry(Enquiries enquiry);

	List<Enquiries> getAllEnquiries();

	Enquiries getEnquiryById(Long enquiryId);

}
