package com.masai.service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.masai.entities.Bookings;
import com.masai.entities.Bus;
import com.masai.exception.BookingException;
import com.masai.exception.InvalidDetailsException;

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

	@Override
	public List<Bookings> viewAllBookings(List<Bookings> booking) throws BookingException {
		
		if(booking != null && booking.size() > 0) {
			return booking;
		}else {
			throw new BookingException();
		}
	}

	@Override
	public List<Bookings> viewBookingsByBusName(String busName, List<Bookings> booking) throws BookingException {
		
		List<Bookings> myBookings = new ArrayList<>();

		boolean flag = false;
		for (Bookings bk : booking) {
			if (bk.getBusName().equals(busName)) {

				myBookings.add(bk);

				flag = true;
			}
		}
		if (!flag) {
			throw new BookingException("You don't have any booking ");
		}

		return myBookings;
	}

	@Override
	public List<Bookings> viewBookingsByUserName(String userName, List<Bookings> booking) throws BookingException {
		List<Bookings> myBookings = new ArrayList<>();

		boolean flag = false;
		for (Bookings bk : booking) {
			if (bk.getUsername().equals(userName)) {

				myBookings.add(bk);

				flag = true;
			}
		}
		if (!flag) {
			throw new BookingException("You don't have any booking ");
		}

		return myBookings;
	}

	@Override
	public List<Bookings> viewBookingsByDate(String startDate, String endDate, List<Bookings> booking)
			throws BookingException {
		
		
		LocalDate ld1 = LocalDate.parse(startDate);               
		LocalDate ld2 = LocalDate.parse(endDate);
		
		List<Bookings> myBookings = new ArrayList<>();
		
		boolean flag = false;
		for (Bookings bk : booking) {
			if (bk.getDate().compareTo(ld1)>=0 && bk.getDate().compareTo(ld2)<=0) {

				myBookings.add(bk);

				flag = true;
			}
		}
		if (!flag) {
			throw new BookingException("You don't have any booking ");
		}

		return myBookings;

	}

	@Override
	public void cancelBooking(int bookingId, List<Bookings> booking, Map<Integer, Bus> bus) throws BookingException  {
		
		boolean flag = false;
		for (Bookings bk : booking) {
			
			if (bk.getBookingId() == bookingId) {

				int busId = bk.getBusId();
				
                if(bus.containsKey(busId)) {
                	
                	String departure =bus.get(busId).getDepartureTime();
                	
                	LocalTime lt1 = LocalTime.parse(departure);            //<---departure time in LocalTime format
                	LocalTime lt2 = LocalTime.now();                       //<--current time
                	
                	if(lt2.compareTo(lt1)<=0) {
                		booking.remove(bk);
                		System.out.println("Your booking has been canceled");
                	}else {
                		throw new BookingException("You can not cancel booking now");
                	}
                	
                }
				flag = true;
			}
		}
		if (!flag) {
			throw new BookingException("You don't have any booking with this Id");
		}

		
		
	}

}
