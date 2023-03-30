package com.masai.service;

import java.util.Map;

import com.masai.entities.Passenger;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.InvalidDetailsException;

public class PassengerServiceImpl implements PassengerService{

	@Override
	public void signUp(Passenger pass, Map<String, Passenger> passenger) throws DuplicateDataException {
		
		if (passenger.containsKey(pass.getEmail())) {
			throw new DuplicateDataException("Passenger already exists , please login");
		} else {

			passenger.put(pass.getEmail(), pass);

		}
		
	}

	@Override
	public boolean login(String email, String password, Map<String, Passenger> passenger)throws InvalidDetailsException {
		if (passenger.containsKey(email) ) {
			
			if(passenger.get(email).getPassword().equals(password)) {
				return true;
			}
			else {
				throw new InvalidDetailsException("Invalid Credentials");
			}
			
		} else {
			throw new InvalidDetailsException("you have not sign up yet, please signup");
		}
	}

}
