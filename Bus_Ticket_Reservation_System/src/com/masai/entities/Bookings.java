package com.masai.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Bookings implements Serializable{
	
	private String username;
	private String email;
	private int bookingId;
	private int busId;
	private String busName;
	private int tickets;
	private double price;
	private double total;
	private LocalDate date;
	private LocalTime time;
	
	public Bookings() {
		super();
	}

	public Bookings(String username, String email,int bookingId, int busId, String busName, int tickets, double price,
			double total, LocalDate date, LocalTime time) {
		super();
		this.username = username;
		this.email = email;
		this.bookingId=bookingId;
		this.busId = busId;
		this.busName = busName;
		this.tickets = tickets;
		this.price = price;
		this.total = total;
		this.date = date;
		this.time=time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Bookings [username=" + username + ", email=" + email + ", bookingId=" + bookingId + ", busId=" + busId
				+ ", busName=" + busName + ", tickets=" + tickets + ", price=" + price + ", total=" + total + ", date="
				+ date + ", time=" + time + "]";
	}

	

}
