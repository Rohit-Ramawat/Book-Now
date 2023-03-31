package com.masai.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Bookings implements Serializable{
	
	private String username;
	private String email;
	private int busId;
	private String busName;
	private int tickets;
	private double price;
	private double total;
	private LocalDate dt;
	
	public Bookings() {
		super();
	}

	public Bookings(String username, String email, int busId, String busName, int tickets, double price,
			double total, LocalDate dt) {
		super();
		this.username = username;
		this.email = email;
		this.busId = busId;
		this.busName = busName;
		this.tickets = tickets;
		this.price = price;
		this.total = total;
		this.dt = dt;
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

	public LocalDate getDt() {
		return dt;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}

	@Override
	public String toString() {
		return "Bookings [username=" + username + ", email=" + email + ", busId=" + busId + ", busName=" + busName
				+ ", tickets=" + tickets + ", price=" + price + ", total=" + total + ", dt=" + dt + "]";
	}
	
	
}
