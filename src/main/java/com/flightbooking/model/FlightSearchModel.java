package com.flightbooking.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "FlightSearchModel")
@Table(name = "FLIGHTINFO")
@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightSearchModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "FLIGHT_NO", columnDefinition = "VARCHAR(100)")
	@NotNull
	@Id
	private String flightNo;

	@Column(name = "AIR_LINE_NAME", columnDefinition = "VARCHAR(255)")
	@NotNull
	private String airLine;

	@Column(name = "DEPATURE_TIME", columnDefinition = "TIMESTAMP")
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date depatureTime;

	@Column(name = "ARRIVAL_TIME", columnDefinition = "TIMESTAMP")
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date arriavlTime;

	@Column(name = "PRICE", columnDefinition = "INT")
	@NotNull
	private Integer price;

	@Column(name = "SOURCE_CITY", columnDefinition = "VARCHAR(100)")
	@NotNull
	private String sourceCity;

	@Column(name = "DESTINATION_CITY", columnDefinition = "VARCHAR(100)")
	@NotNull
	private String destinationCity;

	@Column(name = "TRAVEL_DATE", columnDefinition = "DATE")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date travelDate;

	@Column(name = "RETURN_DATE", columnDefinition = "DATE")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date returnDate;

}
