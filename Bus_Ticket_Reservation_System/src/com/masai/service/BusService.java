package com.masai.service;

import java.util.Map;

import com.masai.entities.Bus;



public interface BusService {
	
	public String addBusDetails(Bus busObj, Map<Integer, Bus> busDetails);
	
}
