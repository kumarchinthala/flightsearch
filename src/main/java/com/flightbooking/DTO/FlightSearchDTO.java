package com.flightbooking.DTO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightSearchDTO {

	private String flight_no;

	private String air_line;

	@JsonFormat(locale = "en_US", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "America/New_York")
	@Temporal(TemporalType.TIMESTAMP)
	private Date depature_time;

	@JsonFormat(locale = "en_US", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "America/New_York")
	@Temporal(TemporalType.TIMESTAMP)
	private Date arriavl_time;

	private Integer price;

	private String source_city;

	private String destination_city;

	@JsonFormat(locale = "en_US", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/New_York")
	@Temporal(TemporalType.DATE)
	private Date travel_date;

	@JsonFormat(locale = "en_US", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/New_York")
	@Temporal(TemporalType.DATE)
	private Date return_date;

}
