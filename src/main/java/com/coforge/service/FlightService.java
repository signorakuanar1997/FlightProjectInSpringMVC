package com.coforge.service;

import java.util.List;

import com.coforge.entity.Flight;

public interface FlightService {

	List<Flight> getAllFlights();
    Flight getFlightById(Long id);
    void saveFlight(Flight flight);
    void updateFlight(Flight flight);
    void deleteFlight(Long id);
}
