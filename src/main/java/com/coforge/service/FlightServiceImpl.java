package com.coforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.dao.FlightDao;
import com.coforge.entity.Flight;
@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
    private FlightDao flightDao;

	@Override
	public List<Flight> getAllFlights() {
		return flightDao.getAllFlights();
	}

	@Override
	public Flight getFlightById(Long id) {
		return flightDao.getFlightById(id);
	}

	@Override
	public void saveFlight(Flight flight) {
		flightDao.saveFlight(flight);
		
	}

	@Override
	public void updateFlight(Flight flight) {
		flightDao.updateFlight(flight);
		
	}

	@Override
	public void deleteFlight(Long id) {
		flightDao.deleteFlight(id);
		
	}
	
	
}
