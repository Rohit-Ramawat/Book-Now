package com.masai.service;

import java.util.Map;

import com.masai.entities.Bus;
import com.masai.exception.BusException;

public class BusServiceImpl implements BusService{

	@Override
	public String addBusDetails(Bus busObj, Map<Integer, Bus> busDetails) {
		
		busDetails.put(busObj.getId(), busObj);
		
		return "Bus Details added successfully";
	}

	@Override
	public void viewAllProducts(Map<Integer, Bus> bus) throws BusException {
		
		if (bus != null && bus.size() > 0) {
			for (Map.Entry<Integer, Bus> me : bus.entrySet()) {
				System.out.println(me.getValue());
			}

		} else {
			throw new BusException("Product List is empty");
		}
		
	}

	@Override
	public void deleteBus(int id, Map<Integer, Bus> bus) throws BusException {
		
		if (bus != null && bus.size() > 0) {

			if (bus.containsKey(id)) {
				bus.remove(id);
				System.out.println("Bus details deleted successfully");

			} else {
				throw new BusException("Bus details not found");
			}

		} else {
			throw new BusException("Bus details list is empty");
		}
		
	}

	@Override
	public String updateBus(int id, Bus busObj, Map<Integer, Bus> bus) throws BusException {
		
		if (bus != null && bus.size() > 0) {

			if (bus.containsKey(id)) {
				bus.put(id, busObj);
				return "Bus has successfully updated";
			} else {
				throw new BusException("Bus not found");
			}

		} else {
			throw new BusException("Bus list is empty");
		}
	}
	
	
}
