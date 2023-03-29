package com.masai.service;

import java.util.Map;

import com.masai.entities.Bus;

public class BusServiceImpl implements BusService{

	@Override
	public String addBusDetails(Bus busObj, Map<Integer, Bus> busDetails) {
		
		busDetails.put(busObj.getId(), busObj);
		
		return "Bus Details added successfully";
	}
	
	
}
