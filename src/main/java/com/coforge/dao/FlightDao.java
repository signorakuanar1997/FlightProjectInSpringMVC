package com.coforge.dao;

import java.util.List;

import com.coforge.entity.Flight;

public interface FlightDao {

	void saveFlight(Flight flight);
    void updateFlight(Flight flight);
    void deleteFlight(Long id);
    Flight getFlightById(Long id);
    List<Flight> getAllFlights();
	
}
