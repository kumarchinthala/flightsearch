package com.flightbooking.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightbooking.model.FlightSearchModel;

@Repository
public interface FlightSearchRepository extends JpaRepository<FlightSearchModel, String> {
    @Modifying
	//@Query(value ="select f from FlightSearchModel f where f.sourceCity=:sourceCity and f.destinationCity=:destinationCity and cast(f.travelDate as DATE)=:modifiedTravelDate and CAST(f.returnDate as DATE)=:modifiedReturnDate")
	List<FlightSearchModel> findBySourceCityAndDestinationCityAndTravelDateAndReturnDate(@Param("sourceCity") String sourceCity, @Param("destinationCity") String destinationCity,   
			@Param("travelDate") Date modifiedTravelDate,@Param("returnDate") Date modifiedReturnDate);
	
	//@Query(value = "select f from FlightSearchModel f where f.sourceCity=:sourceCity and f.destinationCity=:destinationCity and CAST(f.travelDate AS DATE)=:modifiedTravelDate",nativeQuery =true)
	List<FlightSearchModel>  findBySourceCityAndDestinationCityAndTravelDate(@Param("sourceCity") String sourceCity, @Param("destinationCity") String destinationCity,   
			@Param("travelDate") Date modifiedTravelDate);
}
