package com.masai.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.masai.entities.Bookings;
import com.masai.entities.Bus;
import com.masai.entities.Passenger;
import com.masai.exception.BusException;
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

	@Override
	public boolean bookingTickets(int id, int tickets, String email, Map<Integer, Bus> bus,
			Map<String, Passenger> passenger, List<Bookings> booking) throws InvalidDetailsException, BusException {
		
		if (bus.size() == 0)
			throw new BusException("Bus list is empty");

		if (bus.containsKey(id)) {

			Bus busObj = bus.get(id);

			if (busObj.getTotalSeats() >= tickets) {

				Passenger pass = passenger.get(email);

				double buyingPrice = tickets * busObj.getTicketPrice();

				if (pass.getWalletBalance() >= buyingPrice) {
					pass.setWalletBalance(pass.getWalletBalance() - buyingPrice);

					busObj.setTotalSeats(busObj.getTotalSeats()-tickets);

					bus.put(id, busObj);

					Bookings bk = new Bookings(pass.getUsername(), email, id, busObj.getBusName(), tickets,
							busObj.getTicketPrice(), buyingPrice, LocalDate.now(), LocalTime.now());

					booking.add(bk);

				} else {
					throw new InvalidDetailsException("wallet balance is not sufficient");
				}

			} else {
				throw new InvalidDetailsException("Enough bus seats are not available");
			}

		} else {
			throw new InvalidDetailsException("There is not any bus with this number: " + id);
		}

		return false;
		
	}

	@Override
	public boolean addMoneyToWallet(double amount, String email, Map<String, Passenger> passenger) {
		Passenger pass = passenger.get(email);

		pass.setWalletBalance(pass.getWalletBalance() + amount);

		passenger.put(email, pass);

		return true;
	}

	@Override
	public double viewWalletBalance(String email, Map<String, Passenger> passenger) {
		
		Passenger pass = passenger.get(email);
		return pass.getWalletBalance();
		
	}

	@Override
	public void deletePassenger(String email,String password, Map<String, Passenger> passenger) throws InvalidDetailsException {
		
		if (passenger.containsKey(email)) {
			if(passenger.get(email).getPassword().equals(password)) {
				passenger.remove(email);
			}
			else {
				throw new InvalidDetailsException("Invalid Credentials");
			}

		} 
	}

	@Override
	public String updateEmail(String email, Map<String, Passenger> passenger, String email2) throws InvalidDetailsException {
		
		if(passenger.containsKey(email)) {
			passenger.get(email).setPassword(email2);
			return "Email Updated Successfully";
		}else {
			throw new InvalidDetailsException();
		}
	}

	@Override
	public String updatePassword(String email, Map<String, Passenger> passenger, String password) throws InvalidDetailsException {
		if(passenger.containsKey(email)) {
			passenger.get(email).setPassword(password); 
			return "Password Updated Successfully";
		}else {
			throw new InvalidDetailsException();
		}
	}

	@Override
	public String updateAddress(String email, Map<String, Passenger> passenger, String address) throws InvalidDetailsException {
		if(passenger.containsKey(email)) {
			passenger.get(email).setAddress(address);
			return "Address Updated Successfully";
		}else {
			throw new InvalidDetailsException();
		}
	}

	@Override
	public String updateMobileNo(String email, Map<String, Passenger> passenger, long mobileNo) throws InvalidDetailsException {
		if(passenger.containsKey(email)) {
			passenger.get(email).setMobileNo(mobileNo);
			return "Mobile Number Updated Successfully";
		}else {
			throw new InvalidDetailsException();
		}
	}


}
