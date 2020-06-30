package com.flightbooking.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.flightbooking.DTO.FlightSearchDTO;
import com.flightbooking.model.FlightSearchModel;
import com.flightbooking.repository.FlightSearchRepository;
import com.flightbooking.util.FlightUtil;

@Service
public class FlightSearchService {
 
	@Autowired
	private FlightSearchRepository flightSearchRepository;
	
	public Optional<List<FlightSearchDTO>> getFlightInfo(){
		 List<FlightSearchDTO> flightInfoDtoList = new ArrayList<FlightSearchDTO>();
		 List<FlightSearchModel> flightInfoList = flightSearchRepository.findAll();
		
			 
			if (!flightInfoList.isEmpty()) {
				flightInfoList.forEach(flightInfo -> {
					FlightSearchDTO InfoDto = setFlightInfoDtoRecord(Optional.ofNullable(flightInfo));
					 
					flightInfoDtoList.add(InfoDto);
				});
			}
		return Optional.ofNullable(flightInfoDtoList);
		
	}

	private FlightSearchDTO setFlightInfoDtoRecord(Optional<FlightSearchModel> flightInfo) {
		FlightSearchDTO InfoDto = FlightSearchDTO.builder().flight_no(flightInfo.get().getFlightNo())
				                  .air_line(flightInfo.get().getAirLine())
				                  .depature_time(flightInfo.get().getDepatureTime())
				                  .arriavl_time(flightInfo.get().getArriavlTime())
				                  .price(flightInfo.get().getPrice())
				                  .source_city(flightInfo.get().getSourceCity())
				                  .destination_city(flightInfo.get().getDestinationCity())
				                  .travel_date(flightInfo.get().getTravelDate())
				                  .return_date(flightInfo.get().getReturnDate())
				                  .build();
		return InfoDto;
	}

	public Optional<List<FlightSearchDTO>> getFlightDetails(String sourceCity, String destinationCity,
			String travelDate, String returnDate) {
		List<FlightSearchModel> flightSearchInfoList = null;
		 List<FlightSearchDTO> flightInfoDtoList = new ArrayList<FlightSearchDTO>();
		Date modifiedTravelDate = null;
		Date modifiedReturnDate = null;
		try {
			  modifiedTravelDate = FlightUtil.convertStringtoDate(travelDate);
			if (StringUtils.containsWhitespace(returnDate)){
				
			flightSearchInfoList = flightSearchRepository.findBySourceCityAndDestinationCityAndTravelDate(sourceCity, destinationCity, modifiedTravelDate);
			}else {
				modifiedReturnDate = FlightUtil.convertStringtoDate(returnDate);
				flightSearchInfoList = flightSearchRepository.findBySourceCityAndDestinationCityAndTravelDateAndReturnDate(sourceCity, destinationCity, modifiedTravelDate, modifiedReturnDate);
			}
			
			if (!flightSearchInfoList.isEmpty()) {
				flightSearchInfoList.forEach(flightInfo -> {
					FlightSearchDTO InfoDto = setFlightInfoDtoRecord(Optional.ofNullable(flightInfo));
					 
					flightInfoDtoList.add(InfoDto);
					
				});
			}
		} catch ( ParseException | java.text.ParseException e) {
			e.printStackTrace();
		}
		 
		return Optional.ofNullable(flightInfoDtoList);
	}
	
	
	
	
}
