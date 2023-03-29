package com.masai;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.entities.Bookings;
import com.masai.entities.Bus;
import com.masai.entities.Passenger;
import com.masai.exception.InvalidDetailsException;
import com.masai.service.BusService;
import com.masai.service.BusServiceImpl;
import com.masai.utility.Admin;
import com.masai.utility.FileExists;
import com.masai.utility.IDGeneration;

public class Main {
	
	// Administration functionality part-->
	private static void adminFunctionality(Scanner sc, Map<Integer, Bus> bus, Map<String, Passenger> passenger,
			List<Bookings> booking) throws InvalidDetailsException {
		
		adminLogin(sc);    //<-----admin login 
		
		//service class's objects 
		BusService busService = new BusServiceImpl();
		//PassengerService passService = new PassengerServiceImpl();
		//BookingsService bookService = new BookingsServiceImpl();
		
		int choice =0;
		try {
			do {
				System.out.println("Press 1 add the product");
				System.out.println("Press 2 view all the product");
				System.out.println("Press 3 delete the product");
				System.out.println("Press 4 update the product");
				System.out.println("Press 5 view all customers");
				System.out.println("Press 6 to view all transactions");
				System.out.println("Press 7 to log out");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					String added = adminAddBusDetails(sc,bus,busService);    //calling method to add details
					System.out.println(added);
					break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (choice <= 6);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void adminLogin(Scanner sc) throws InvalidDetailsException {

		System.out.println("Enter the user name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		if (userName.equals(Admin.username) && password.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvalidDetailsException("Invalid Admin Credentials");
		}
	}
	
	public static String adminAddBusDetails(Scanner sc, Map<Integer, Bus> bus, BusService busService) {
		
		String str="";
		
		//Bus Detals-->
		System.out.println("Please Enter Bus Details");
		System.out.println("Enter bus name");
		String busName = sc.next();
		System.out.println("Enter bus type");
		String busType =sc.next();
		System.out.println("Enter ticket price");
		double ticketPrice = sc.nextDouble();
		System.out.println("Enter total seats");
		int totalSeats = sc.nextInt();
		System.out.println("Enter source ");
		String source = sc.next();
		System.out.println("Enter destination ");
		String destination = sc.next();
		System.out.println("Enter Departure Time ");
		String departureTime = sc.next();
		System.out.println("Enter Arrival Time ");
		String arrivalTime = sc.next();
		
		//Creating Bus class object
		Bus busObject = new Bus(busName,busType, IDGeneration.generateId(),ticketPrice,totalSeats,
				source,destination,departureTime,arrivalTime);

		str = busService.addBusDetails(busObject, bus);
		
		return str;
	}
	
	
	
	
	//passenger functionality part-->
	private static void passengerSignup(Scanner sc, Map<String, Passenger> passenger) {
		
		
	}

	private static void passengerFunctionality(Scanner sc, Map<String, Passenger> passenger, Map<Integer, Bus> bus,
			List<Bookings> booking) {
		
		
	}

	public static void main(String[] args) {
		
		Map<Integer,Bus> bus = FileExists.busFile();
		Map<String,Passenger> passenger = FileExists.passengerFile();
		List<Bookings> booking = FileExists.bookingFile();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello Welcome , in Bus Ticket Reservation System");
        
		try {
			
			int preference = 0;
			
			do {
				System.out.println("Please enter your preference, " + " '1' --> Admin login , '2' --> Customer login , "
						+ "'3' for Customer signup, '0' for exit");
				
				preference = sc.nextInt();
				
				switch (preference) {
				
				case 1: 
					adminFunctionality(sc, bus, passenger, booking);
					break;
				
				case 2:
					passengerFunctionality(sc, passenger, bus, booking);
					break;

				case 3:
					passengerSignup(sc, passenger);
					break;

				case 0:
					System.out.println("successfully existed from the system");
					break;	
					
				default:
					throw new IllegalArgumentException("Invalid Selection ");
				}
				
			} while (preference != 0);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			// serialization (finally always executed)
			try {
				ObjectOutputStream busData = new ObjectOutputStream(new FileOutputStream("Bus.ser"));
				busData.writeObject(bus);
				ObjectOutputStream passengerData = new ObjectOutputStream(new FileOutputStream("Passenger.ser"));
				passengerData.writeObject(passenger);

				ObjectOutputStream bookingData = new ObjectOutputStream(new FileOutputStream("Bookings.ser"));
				bookingData.writeObject(booking);
			//	System.out.println("serialized..........");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
	}

	

	

}
