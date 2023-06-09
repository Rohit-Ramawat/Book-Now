package com.masai;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.masai.entities.Bookings;
import com.masai.entities.Bus;
import com.masai.entities.Passenger;
import com.masai.exception.BookingException;
import com.masai.exception.BusException;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.InvalidDetailsException;
import com.masai.service.BookingService;
import com.masai.service.BookingServiceImpl;
import com.masai.service.BusService;
import com.masai.service.BusServiceImpl;
import com.masai.service.PassengerService;
import com.masai.service.PassengerServiceImpl;
import com.masai.utility.Admin;
import com.masai.utility.FileExists;
import com.masai.utility.IDGeneration;

public class Main {
	
	// Administration functionality part-->
	public static void adminFunctionality(Scanner sc, Map<Integer, Bus> bus, Map<String, Passenger> passenger,
			List<Bookings> booking) throws InvalidDetailsException {
		
		adminLogin(sc);    //<-----Administrator login 
		
		//service class's objects 
		BusService busService = new BusServiceImpl();
		PassengerService passService = new PassengerServiceImpl();
		BookingService bookService = new BookingServiceImpl();
		
		int choice =0;
		try {
			do {
				System.out.println("---------------------------------------------");
				System.out.println("Press 1 add the new bus details");
				System.out.println("Press 2 view all the bus's details");
				System.out.println("Press 3 delete any bus details");
				System.out.println("Press 4 update the bus details");
				System.out.println("Press 5 view all passengers");
				System.out.println("Press 6 to view all bookings");
				System.out.println("Press 7 to view booking by Bus Name");
				System.out.println("Press 8 to view booking by passenger username");
				System.out.println("Press 9 to view booking by date range");
				System.out.println("Press 10 to log out");
				System.out.println("---------------------------------------------");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					String added = adminAddBusDetails(sc,bus,busService);    //calling method to add details
					System.out.println(added);
					break;
				case 2:
					adminViewAllBus(bus, busService);
					break;
				case 3:
					adminDeleteBus(sc, bus, busService);
					break;
				case 4:
					adminUpdateBus(sc, bus, busService);
					break;
				case 5:
					adminViewAllPassengers(passenger, passService);
					break;
				case 6:
					adminViewAllBookings(booking, bookService);
					break;	
				case 7:
					adminViewBookingsByBusName(sc,booking, bookService);
					break;
				case 8:
					adminViewBookingsByUserName(sc,booking, bookService);
					break;	
				case 9:
					adminViewBookingByDate(sc,booking, bookService);
					break;
				case 10:
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (choice <= 9);
			
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
		System.out.println("Enter Departure Time in format(HH:MM:SS)");
		String departureTime = sc.next();
		System.out.println("Enter Arrival Time ");
		String arrivalTime = sc.next();
		
		//Creating Bus class object
		Bus busObject = new Bus(busName,busType, IDGeneration.generateId(),ticketPrice,totalSeats,
				source,destination,departureTime,arrivalTime);

		str = busService.addBusDetails(busObject, bus);      //calling service class function
		
		return str;
	}
	
	public static void adminViewAllBus(Map<Integer, Bus> bus, BusService busService)throws BusException {
		
		busService.viewAllBuses(bus);        //calling service class function
	
	}
	
	public static void adminDeleteBus(Scanner sc, Map<Integer, Bus> bus, BusService busService)throws BusException {

		System.out.println("please enter the id of bus, details of which is to be deleted");
		int id = sc.nextInt();
		busService.deleteBus(id, bus);
	} 
	
	public static void adminUpdateBus(Scanner sc, Map<Integer, Bus> bus, BusService busService)throws BusException {
		
		String res="no chnages";
		System.out.println("please enter the id of the bus, details of which is to be updated");
		
		int id = sc.nextInt();
		
		int choice =0;
		try {
			do {
				System.out.println("--------------------------------");
				System.out.println("Press 1 to update bus name");
				System.out.println("Press 2 to update bus type");
				System.out.println("Press 3 to update bus totalseats");
				System.out.println("Press 4 to go back");
				System.out.println("--------------------------------");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter new Bus name");
					String name = sc.next();
					res=busService.updateBusName(id,bus,name);
					System.out.println(res);
					break;
				case 2:
					System.out.println("Enter new Bus Type");
					String type = sc.next();
					res=busService.updateBusType(id,bus,type);
					System.out.println(res);
					break;
				case 3:
					System.out.println("Enter the updated total seats");
					int totalseats = sc.nextInt();
					res=busService.updateBusSeats(id, bus, totalseats);
					System.out.println(res);
					break;
				case 4:
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (choice <= 3);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void adminViewAllPassengers(Map<String, Passenger> passenger, PassengerService passService) 
			throws BusException {
		
		List<Passenger> list = passService.viewAllCustomers(passenger);

		for (Passenger p : list) {
			System.out.println(p);
		}
		
	}

	public static void adminViewAllBookings(List<Bookings> booking, BookingService bookService) 
			throws BookingException {
		
		List<Bookings> list = bookService.viewAllBookings(booking);
		
		for (Bookings b : list) {
			System.out.println(b);
		}
		
	}
	
	public static void adminViewBookingsByBusName(Scanner sc,List<Bookings> booking, BookingService bookService)
			throws BookingException {
		System.out.println("Enter busname");
		String busName = sc.next();
		List<Bookings> list = bookService.viewBookingsByBusName(busName,booking);
		
		for (Bookings b : list) {
			System.out.println(b);
		}
		
	}
	
	private static void adminViewBookingsByUserName(Scanner sc, List<Bookings> booking, BookingService bookService) 
			throws BookingException {
		System.out.println("Enter Username");
		String userName = sc.next();
		List<Bookings> list = bookService.viewBookingsByUserName(userName,booking);
		
		for (Bookings b : list) {
			System.out.println(b);
		}
		
	}


	public static void adminViewBookingByDate(Scanner sc, List<Bookings> booking, BookingService bookService) 
		    throws BookingException {
		System.out.println("Enter Start Date in YYYY-MM-DD format");
		String startDate = sc.next();
		System.out.println("Enter End Date in YYYY-MM-DD format");
		String endDate = sc.next();
		List<Bookings> list = bookService.viewBookingsByDate(startDate,endDate,booking);
		
		for (Bookings b : list) {
			System.out.println(b);
		}
		
		
	}


	//passenger functionality part-->
	public static void passengerSignup(Scanner sc, Map<String, Passenger> passenger) throws DuplicateDataException{
		
		System.out.println("please enter the following details to Signup");
		System.out.println("please enter the user name");
		String name = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		System.out.println("enter the address");
		String address = sc.next();
		System.out.println("Enter the email id");
		String email = sc.next();
		System.out.println("Enter the mobile number");
		long mobileNo = sc.nextLong();
		System.out.println("Enter the balance to be added into the wallet");
		double balance = sc.nextDouble();
		Passenger pass = new Passenger(balance, name, password, address, email,mobileNo);

		PassengerService passService = new PassengerServiceImpl();
		passService.signUp(pass, passenger);
		System.out.println("Passenger has Succefully signed up");
	}
    
	public static void passengerLogin(String email,String password, Map<String, Passenger> passenger, PassengerService passService)
			throws InvalidDetailsException {
		
		passService.login(email, password,passenger);
		System.out.println("Passenger has successfully login");

	}
	
	public static void passengerFunctionality(Scanner sc, Map<String, Passenger> passenger, Map<Integer, Bus> bus,
			List<Bookings> booking) throws InvalidDetailsException {
		
		PassengerService passService = new PassengerServiceImpl();
		BusService busService = new BusServiceImpl();
		BookingService bookingService = new BookingServiceImpl();

		// Customer login
		System.out.println("please enter the following details to login");
		System.out.println("please enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		passengerLogin(email,password, passenger, passService);

		try {
			int choice = 0;  
			do {
				System.out.println("---------------------------------------");
				System.out.println("Select the option of your choice");
				System.out.println("Press 1 to view all buses");
				System.out.println("Press 2 to book tickets");
				System.out.println("Press 3 to add money to a wallet");
				System.out.println("Press 4 view wallet balance");
				System.out.println("Press 5 to view your personal details");
				System.out.println("Press 6 to change personal details");
				System.out.println("Press 7 to view my booking history");
				System.out.println("Press 8 to cancel a booking");
				System.out.println("Press 9 to delete account");
				System.out.println("Press 10 to logout");
				System.out.println("---------------------------------------");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					passengerViewAllBuses(bus, busService);
					break;
				case 2:
					String result = passengerBookingTickets(sc, email, bus, passenger, booking, passService);
					System.out.println(result);
					break;
				case 3:
					String moneyAdded = passenegerAddMoneyToWallet(sc, email, passenger, passService);
					System.out.println(moneyAdded);
					break;
				case 4:
					double walletBalance = passengerViewWalletBalance(email, passenger, passService);
					System.out.println("Wallet balance is: " + walletBalance);
					break;
				case 5:
					passengerViewMyDetails(email, passenger, passService);
					break;	
				case 6:
					passengerChangeDetails(sc, passenger, passService);
					break;
				case 7:
					passengerViewBookings(email, booking, bookingService);
					break;
				case 8:
					passengerCancelBooking(sc,booking,bookingService,bus);
					break;
				case 9:
					passengerDeleteAccount(sc, passenger, passService);
					System.out.println("Your account has been deleted");
					return;	
				case 10:
					System.out.println("you have successsfully logout");
					break;
				default:
				    System.out.println("invalid choice");
					break;
			}

			} while (choice <= 9);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void passengerViewAllBuses(Map<Integer, Bus> bus, BusService busService)
			throws BusException {
		busService.viewAllBuses(bus);
	}

	public static String passengerBookingTickets(Scanner sc, String email, Map<Integer, Bus> bus,
			Map<String, Passenger> passenger, List<Bookings> booking, PassengerService passService) throws InvalidDetailsException, BusException {
		
		System.out.println("Enter the bus number");
		int id = sc.nextInt();
		System.out.println("enter the no of tickets you want to book");
		int tickets = sc.nextInt();
		passService.bookingTickets(id, tickets, email, bus, passenger, booking);
		
		return "You have successfully bought the ticket";
	}

	public static String passenegerAddMoneyToWallet(Scanner sc, String email, Map<String, Passenger> passenger,
			PassengerService passService) {
		System.out.println("please enter the amount");
		double money = sc.nextDouble();
		boolean added = passService.addMoneyToWallet(money, email, passenger);

		return "Amount: " + money + " successfully added to your wallet";
	}
	
	public static double passengerViewWalletBalance(String email, Map<String, Passenger> passenger,
			PassengerService passService) {
		double walletBalance = passService.viewWalletBalance(email, passenger);
		return walletBalance;
	}
	
	public static void passengerViewBookings(String email, List<Bookings> booking, BookingService bookingService) throws BookingException {
		
		List<Bookings> myBookings = bookingService.viewPassengerBooking(email, booking);
        
		for (Bookings bk : myBookings) {
			System.out.println(bk);
		}
		
	}
	
	public static void passengerCancelBooking(Scanner sc, List<Bookings> booking, BookingService bookingService,
			Map<Integer, Bus> bus)throws BookingException {
	    System.out.println("Enter your booking id");
	    int bookingId = sc.nextInt();
	    
	    bookingService.cancelBooking(bookingId,booking,bus);
		
	}
	
	public static void passengerDeleteAccount(Scanner sc, Map<String, Passenger> passenger, PassengerService passService) 
			throws InvalidDetailsException {
        
		System.out.println("please enter your email before deleting");
		String email = sc.next();
		System.out.println("please enter your password before deleting");
		String password = sc.next();
		passService.deletePassenger(email,password, passenger);
	}
	
	public static void passengerViewMyDetails(String email, Map<String, Passenger> passenger,PassengerService passService) {
		
		Passenger pass = passService.viewPassenegrDetails(email, passenger);
		System.out.println("name : " + pass.getUsername());
		System.out.println("address : " + pass.getAddress());
		System.out.println("email : " + pass.getEmail());
		System.out.println("mobile number : " + pass.getMobileNo());
		System.out.println("wallet balance : " + pass.getWalletBalance());
		
	}
	
	public static void passengerChangeDetails(Scanner sc,Map<String, Passenger> passenger, PassengerService passService)
			throws InvalidDetailsException {
		
		String res="no chnages";
		System.out.println("Enter your email");
		
		String email = sc.next();
		
		int choice =0;
		try {
			do {
				System.out.println("-------------------------------");
				System.out.println("Press 1 to change email");
				System.out.println("Press 2 to change password");
				System.out.println("Press 3 to change address");
				System.out.println("Press 4 to change Mobile number");
				System.out.println("Press 5 to go back");
				System.out.println("-------------------------------");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter new email");
					String emailNew = sc.next();
					res=passService.updateEmail(email,passenger,email);
					System.out.println(res);
					break;
				case 2:
					System.out.println("Enter new password");
					String password = sc.next();
					res=passService.updatePassword(email,passenger,password);
					System.out.println(res);
					break;
				case 3:
					System.out.println("Enter new address");
					String address = sc.next();
					res=passService.updateAddress(email, passenger, address);
					System.out.println(res);
					break;
				case 4:
					System.out.println("Enter new mobile number");
					long mobileNo = sc.nextLong();
					res=passService.updateMobileNo(email,passenger,mobileNo);
					System.out.println(res);
					break;
				case 5:
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (choice <= 4);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Map<Integer,Bus> bus = FileExists.busFile();
		Map<String,Passenger> passenger = FileExists.passengerFile();
		List<Bookings> booking = FileExists.bookingFile();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------Hello Dear User, Welcome in Bus Ticket Reservation System-------");
        
		try {
			
			int preference = 0;
			
			do {
				System.out.println("-------------------------------------");
				System.out.println("Please enter your preference, Press");
				System.out.println("'1' --> Admin login");
				System.out.println("'2' --> Passenger login");
				System.out.println("'3' --> for Passenger signup");
				System.out.println("'0' --> for exit");
				System.out.println("-------------------------------------");
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
