package com.flightbooking.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.DTO.FlightSearchDTO;
import com.flightbooking.service.FlightSearchService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class FlightSearchController {
	
	@Autowired
	private FlightSearchService flightSearchService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<FlightSearchDTO>> getAll(){
		Optional<List<FlightSearchDTO>> response = null;
		List<FlightSearchDTO> results = null;
		try {
			response = flightSearchService.getFlightInfo();
			if (response.isPresent()) {
				results = response.get().parallelStream().collect(Collectors.toList());
			} else {
				results = Collections.emptyList();
			}
		} catch (Exception e) {
			 

			log.error("Error in getAll : " + e.getMessage());
			return new ResponseEntity<>(results, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(results, HttpStatus.OK);
		
		
	}
	
	@GetMapping(value = "/flightsearch")
	public ResponseEntity<List<FlightSearchDTO>> getFlightInfo(@RequestParam(value ="sourceCity",required = true) String sourceCity,
			@RequestParam(value ="destinationCity",required = true) String destinationCity,
			@RequestParam(value ="travelDate",required = true) String travelDate,
			@RequestParam(value ="returnDate",required = false,defaultValue = " ") String returnDate){
		Optional<List<FlightSearchDTO>> response = null;
		List<FlightSearchDTO> results = null;
		try {
			response = flightSearchService.getFlightDetails(sourceCity,destinationCity,travelDate,returnDate);
			if (response.isPresent()) {
				results = response.get().parallelStream().sorted(Comparator.comparingInt(FlightSearchDTO::getPrice)).collect(Collectors.toList());
			} else {
				results = Collections.emptyList();
			}
		} catch (Exception e) {
			 

			log.error("Error in getFlightInfo method : " + e.getMessage());
			return new ResponseEntity<>(results, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(results, HttpStatus.OK);
		
		
	}


}
