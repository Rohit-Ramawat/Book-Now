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
	public void viewAllBuses(Map<Integer, Bus> bus) throws BusException {
		if (bus != null && bus.size() > 0) {
			for (Map.Entry<Integer, Bus> me : bus.entrySet()) {
				System.out.println(me.getValue());
			}

		} else {
			throw new BusException("Bus List is empty");
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
	public String updateBusName(int id, Map<Integer, Bus> bus, String name) throws BusException {
		if (bus != null && bus.size() > 0) {
			if(bus.containsKey(id)) {
				for(Map.Entry<Integer, Bus> mp : bus.entrySet()) {
					if(mp.getValue().getId() == id ) {
						mp.getValue().setBusName(name);
					}
				}
				return "Bus Name Updated Successfully";
			} else {
				throw new BusException("Bus Not Found");
			}

		} else {
			throw new BusException("Bus list is empty");
		}
	}

	@Override
	public String updateBusType(int id, Map<Integer, Bus> bus, String type) throws BusException {
		if (bus != null && bus.size() > 0) {
			if(bus.containsKey(id)) {
				for(Map.Entry<Integer, Bus> mp : bus.entrySet()) {
					if(mp.getValue().getId() == id ) {
						mp.getValue().setBusType(type);
					}
				}
				return "Bus Type Updated Successfully";
			}else {
				throw new BusException("Bus Not Found");
			}
		} else {
			throw new BusException("Bus list is empty");
		}
	}

	@Override
	public String updateBusSeats(int id, Map<Integer, Bus> bus, int seats) throws BusException {
		if (bus != null && bus.size() > 0) {
			if(bus.containsKey(id)) {
				for(Map.Entry<Integer, Bus> mp : bus.entrySet()) {
					if(mp.getValue().getId() == id ) {
						mp.getValue().setTotalSeats(seats);
					}
				}
				return "Bus Seats Updated Successfully";
			}else {
				throw new BusException("Bus Not Found");
			}
			

		} else {
			throw new BusException("Bus list is empty");
		}
	}



	
	
	
}
