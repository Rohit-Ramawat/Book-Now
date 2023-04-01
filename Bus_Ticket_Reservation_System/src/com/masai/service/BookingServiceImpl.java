package com.masai.service;


import java.util.ArrayList;
import java.util.List;

import com.masai.entities.Bookings;
import com.masai.exception.BookingException;

public class BookingServiceImpl implements BookingService{


	@Override
	public List<Bookings> viewPassengerBooking(String email, List<Bookings> booking) throws BookingException {
		
		List<Bookings> myBookings = new ArrayList<>();

		boolean flag = false;
		for (Bookings bk : booking) {
			if (bk.getEmail().equals(email)) {

				myBookings.add(bk);

				flag = true;
			}
		}
		if (!flag) {
			throw new BookingException("You don't have any booking ");
		}

		return myBookings;
		
	}


}
