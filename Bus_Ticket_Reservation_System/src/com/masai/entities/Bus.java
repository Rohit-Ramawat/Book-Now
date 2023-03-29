package com.masai.entities;

import java.io.Serializable;
import java.util.Objects;

public class Bus implements Serializable{
	
	private String busName;
	private String busType;
	private int id;
	private double ticketPrice;
	private int totalSeats;
	private String source;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	
	public Bus() {
		super();
	}

	public Bus(String busName, String busType, int id, double ticketPrice, int totalSeats, String source,
			String destination, String departureTime, String arrivalTime) {
		super();
		this.busName = busName;
		this.busType = busType;
		this.id = id;
		this.ticketPrice = ticketPrice;
		this.totalSeats = totalSeats;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(arrivalTime, busName, busType, departureTime, destination, id, source, ticketPrice,
				totalSeats);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		return Objects.equals(arrivalTime, other.arrivalTime) && Objects.equals(busName, other.busName)
				&& Objects.equals(busType, other.busType) && Objects.equals(departureTime, other.departureTime)
				&& Objects.equals(destination, other.destination) && id == other.id
				&& Objects.equals(source, other.source)
				&& Double.doubleToLongBits(ticketPrice) == Double.doubleToLongBits(other.ticketPrice)
				&& totalSeats == other.totalSeats;
	}

	@Override
	public String toString() {
		return "Bus [busName=" + busName + ", busType=" + busType + ", id=" + id + ", ticketPrice=" + ticketPrice
				+ ", totalSeats=" + totalSeats + ", source=" + source + ", destination=" + destination
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}
	
	
}
