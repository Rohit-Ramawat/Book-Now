package com.masai.service;

import java.util.List;

import com.masai.entities.Bookings;
import com.masai.exception.BookingException;



public interface BookingService {

	public List<Bookings> viewPassengerBooking(String email, List<Bookings> booking)throws BookingException;
	
}
