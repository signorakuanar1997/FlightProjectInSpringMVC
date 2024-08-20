package com.coforge.controller;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coforge.entity.Flight;
import com.coforge.service.FlightService;

@Controller
@RequestMapping("/flights")
public class FlightController {
	
	 @Autowired
	    private FlightService flightService;
	 
	 
	 @ModelAttribute("flight")
	 public Flight prepareFlight(Flight flight) {
	     if (flight.getDepartureTime() != null) {
	         String formattedDepartureTime = flight.getDepartureTime()
	             .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
	         // Assuming you have a separate field to hold this formatted string
	         // flight.setFormattedDepartureTime(formattedDepartureTime);
	     }
	     if (flight.getArrivalTime() != null) {
	         String formattedArrivalTime = flight.getArrivalTime()
	             .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
	         // Assuming you have a separate field to hold this formatted string
	         // flight.setFormattedArrivalTime(formattedArrivalTime);
	     }
	     return flight;
	 }

	    @GetMapping
	    public String listFlights(Model model) {
	        model.addAttribute("flights", flightService.getAllFlights());
	        return "flight-list";
	    }

	    @GetMapping("/new")
	    public String showCreateForm(Model model) {
	        model.addAttribute("flight", new Flight());
	        return "flight-form";
	    }

	    @PostMapping
	    public String saveFlight(@ModelAttribute("flight") Flight flight) {
	        flightService.saveFlight(flight);
	        return "redirect:/flights";
	    }

	    @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
	        Flight flight = flightService.getFlightById(id);
	        model.addAttribute("flight", flight);
	        return "flight-form";
	    }

	    @PutMapping("/update")
	    public String updateFlight(@ModelAttribute("flight") Flight flight) {
	        flightService.updateFlight(flight);
	        return "redirect:/flights";
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteFlight(@PathVariable("id") Long id) {
	        flightService.deleteFlight(id);
	        return "redirect:/flights";
	    }

}
