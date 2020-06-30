package com.flightbooking.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class FlightUtil {

	public static Date convertStringtoDate(String dateInString) throws  java.text.ParseException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = df.parse(dateInString);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;

	}
}
