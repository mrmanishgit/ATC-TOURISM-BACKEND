package com.aja.service;

import java.util.List;

import com.aja.entity.Enquiries;

public interface EnquiriesService {

	public	Enquiries saveEnquiry(Enquiries enquiry);

	public List<Enquiries> getAllEnquiries();

	public Enquiries getEnquiryById(Long enquiryId);

}
