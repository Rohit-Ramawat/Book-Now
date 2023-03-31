package com.masai.service;

import java.util.Map;

import com.masai.entities.Bus;
import com.masai.exception.BusException;



public interface BusService {
	
	public String addBusDetails(Bus busObj, Map<Integer, Bus> busDetails);
	
	public void viewAllBuses(Map<Integer, Bus> bus) throws BusException;
	
	public void deleteBus(int id, Map<Integer, Bus> bus) throws BusException;
	
	public String updateBusName(int id, Map<Integer, Bus> bus, String name) throws BusException;
	
	public String updateBusType(int id, Map<Integer, Bus> bus, String type) throws BusException;
	
	public String updateBusSeats(int id, Map<Integer, Bus> bus, int seats) throws BusException;
}
