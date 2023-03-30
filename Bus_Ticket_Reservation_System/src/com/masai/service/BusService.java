package com.masai.service;

import java.util.Map;

import com.masai.entities.Bus;
import com.masai.exception.BusException;



public interface BusService {
	
	public String addBusDetails(Bus busObj, Map<Integer, Bus> busDetails);
	
	public void viewAllProducts(Map<Integer, Bus> bus) throws BusException;
	
	public void deleteBus(int id, Map<Integer, Bus> bus) throws BusException;
	
	public String updateBus(int id, Bus busObj, Map<Integer, Bus> bus) throws BusException;
	
}
