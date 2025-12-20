package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.PaymentDeleteResponseDto;
import com.aja.Dto.PaymentsRequestDto;
import com.aja.Dto.PaymentsResponseDto;
import com.aja.entity.Bookings;
import com.aja.entity.Payments;
import com.aja.entity.Users;
import com.aja.repository.BookingsRepo;
import com.aja.repository.PaymentsRepo;
import com.aja.repository.UsersRepo;
import com.aja.service.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService {

	@Autowired
	private PaymentsRepo paymentsRepository;
	@Autowired
    private UsersRepo usersRepository;
    @Autowired
    private BookingsRepo bookingsRepository;


	/* Add payment details */
	@Override
	public PaymentsResponseDto createPayment(PaymentsRequestDto pdto) {

		Payments py = new Payments();
		BeanUtils.copyProperties(pdto, py);
		
		Users user = usersRepository.findById(pdto.getUserId()).orElse(null);
		py.setUser(user);
		
		Bookings booking = bookingsRepository.findById(pdto.getBookingId()).orElse(null);
		py.setBooking(booking);
		
		Payments saveEnt = paymentsRepository.save(py);
		PaymentsResponseDto pyrd = new PaymentsResponseDto();
		BeanUtils.copyProperties(saveEnt, pyrd);
		
	
		pyrd.setUserId(saveEnt.getUser().getUserId());
        pyrd.setBookingId(saveEnt.getBooking().getBookingId());
        
		return pyrd;
	}

	/* payment details visible by id */
	@Override
	public PaymentsResponseDto getPaymentById(Long paymentId) {

		Optional<Payments> py = paymentsRepository.findById(paymentId);
		if (py.isPresent()) {
			PaymentsResponseDto dto = new PaymentsResponseDto();
			BeanUtils.copyProperties(py.get(), dto);

			return dto;
		}
		return null;
	}

	/* All payment details */
	@Override
	public List<PaymentsResponseDto> getAllPayments() {
		// TODO Auto-generated method stub
		List<Payments> paymentsList = paymentsRepository.findAll();
		List<PaymentsResponseDto> resList = new ArrayList<>();
		for (Payments pay : paymentsList) {

			PaymentsResponseDto dto = new PaymentsResponseDto();
			BeanUtils.copyProperties(pay, dto);
			resList.add(dto);
		}
		return resList;
	}
	
	

	/* updated by id */
	@Override
	public PaymentsResponseDto updatePayment(Long paymentId, PaymentsResponseDto payres) {

		Optional<Payments> UpdateById = paymentsRepository.findById(paymentId);
		if (UpdateById.isEmpty()) {
			return null;
		}

		Payments pay = UpdateById.get();

		BeanUtils.copyProperties(payres, pay, "paymentId");
		// update only required or id fields
		Payments updated = paymentsRepository.save(pay);

		PaymentsResponseDto pres = new PaymentsResponseDto();

		BeanUtils.copyProperties(updated, pres);

		return pres;

	}

	/* Delete payment details */
	@Override
	public PaymentDeleteResponseDto deletePayment(Long paymentId) {
		// TODO Auto-generated method stub
		Optional<Payments> delbyId = paymentsRepository.findById(paymentId);

		PaymentDeleteResponseDto payred = new PaymentDeleteResponseDto();

		Payments obj = null;

		if (delbyId.isPresent()) {
			obj = delbyId.get();

			obj.setFlag(false);

			paymentsRepository.save(obj);
			payred.setDeleted(true);
			payred.setMessage("Payment Deleted Successfully");
		}

		else {
			payred.setDeleted(false);
			payred.setMessage("Payment Not  Deleted Successfully");
		}

		return payred;
	}

}
