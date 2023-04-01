package com.masai.service;

import java.util.List;
import java.util.Map;

import com.masai.entities.Bookings;
import com.masai.entities.Bus;
import com.masai.entities.Passenger;
import com.masai.exception.BusException;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.InvalidDetailsException;


public interface PassengerService {
	
	public void signUp(Passenger pass, Map<String, Passenger> passenger) throws DuplicateDataException;
	
	public boolean login(String email,String password, Map<String, Passenger> passenger) throws InvalidDetailsException;

	public boolean bookingTickets(int id, int tickets, String email, Map<Integer, Bus> bus,
			Map<String, Passenger> passenger, List<Bookings> booking)throws InvalidDetailsException, BusException;

	public boolean addMoneyToWallet(double amount, String email, Map<String, Passenger> passenger);
	
	public double viewWalletBalance(String email, Map<String, Passenger> passenger);

	public void deletePassenger(String email,String password, Map<String, Passenger> passenger)throws InvalidDetailsException;

	public String updateEmail(String email, Map<String, Passenger> passenger, String email2)throws InvalidDetailsException;

	public String updatePassword(String email, Map<String, Passenger> passenger, String password)throws InvalidDetailsException;

	public String updateAddress(String email, Map<String, Passenger> passenger, String address)throws InvalidDetailsException;

	public String updateMobileNo(String email, Map<String, Passenger> passenger, long mobileNo)throws InvalidDetailsException;
}
