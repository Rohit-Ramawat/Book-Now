package com.masai.service;

import java.util.List;
import java.util.Map;

import com.masai.entities.Bookings;
import com.masai.entities.Bus;
import com.masai.exception.BookingException;



public interface BookingService {

	public List<Bookings> viewPassengerBooking(String email, List<Bookings> booking)throws BookingException;

	public List<Bookings> viewAllBookings(List<Bookings> booking)throws BookingException;

	public List<Bookings> viewBookingsByBusName(String busName, List<Bookings> booking)throws BookingException;

	public List<Bookings> viewBookingsByUserName(String userName, List<Bookings> booking)throws BookingException;

	public List<Bookings> viewBookingsByDate(String startDate, String endDate, List<Bookings> booking)throws BookingException;

	public void cancelBooking(int bookingId, List<Bookings> booking, Map<Integer, Bus> bus)throws BookingException;

	
}
