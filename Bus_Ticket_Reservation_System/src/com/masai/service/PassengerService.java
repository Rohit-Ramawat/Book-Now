package com.masai.service;

import java.util.List;
import java.util.Map;

import com.masai.entities.Bookings;
import com.masai.entities.Bus;
import com.masai.entities.Passenger;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.InvalidDetailsException;


public interface PassengerService {
	
	public void signUp(Passenger pass, Map<String, Passenger> passenger) throws DuplicateDataException;
	
	public boolean login(String email,String password, Map<String, Passenger> passenger) throws InvalidDetailsException;

	public void bookingTickets(int id, int tickets, String email, Map<Integer, Bus> bus,
			Map<String, Passenger> passenger, List<Bookings> booking);

	
}
