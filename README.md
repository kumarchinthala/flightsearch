# FLIGHT SEARCH 

**Description :** Flight Search Deatils

## Application Features

The following Spring features were used in the project:
  - Spring Boot + Gradle 4
  
## Build & Deploy

This project requires **JDK 8** to build and run the application. 
<br>
<br>
Uses **Ford Gradle boost plugin** to achieve Blue Green deployments. 

## CLI

To start and run the application, run **./gradlew bootRun --args='--spring.profiles.active=local'**. 
<br>
Your local running app is served on http://localhost:9091/.... Press ^C (control-C) to stop your app.

## Endpoints

The Endpoints consume and Produces REST/JSON.
<br>
## DATABASE SetUp
<br>
Login h2 data base:http://localhost:9091/h2-console/
<br>
user name:sa
<br>
password:copy from properties file

##Insert Data Into Table:

<br>
insert into FLIGHTINFO (FLIGHT_NO ,AIR_LINE_NAME ,ARRIVAL_TIME ,DEPATURE_TIME ,DESTINATION_CITY ,PRICE ,RETURN_DATE ,SOURCE_CITY ,TRAVEL_DATE )
Values('AI01','Air India','2020-05-06 08:30','2020-05-06 05:30','delhi',5000,'2020-06-20','chennai','2020-05-17');

<br>
insert into FLIGHTINFO (FLIGHT_NO ,AIR_LINE_NAME ,ARRIVAL_TIME ,DEPATURE_TIME ,DESTINATION_CITY ,PRICE ,RETURN_DATE ,SOURCE_CITY ,TRAVEL_DATE )
Values('SJ01','Spice Jet','2020-05-06 08:30','2020-05-06 05:30','delhi',5000,'2020-06-20','chennai','2020-05-17');


<br>
<br>
 ##URLS:
 https://localhost:9091
 <br>
 http://localhost:9091/swagger-ui.html#!/
 <br>
 http://localhost:9091/all
 #
 [
  {
    "flight_no": "SJ01",
    "air_line": "Spice Jet",
    "depature_time": "2020-05-05 20:00",
    "arriavl_time": "2020-05-05 23:00",
    "price": 5000,
    "source_city": "chennai",
    "destination_city": "delhi",
    "travel_date": "2020-05-17",
    "return_date": "2020-06-20"
  },
  {
    "flight_no": "AI01",
    "air_line": "Air India",
    "depature_time": "2020-05-05 20:00",
    "arriavl_time": "2020-05-05 23:00",
    "price": 5000,
    "source_city": "chennai",
    "destination_city": "delhi",
    "travel_date": "2020-05-17",
    "return_date": "2020-06-20"
  }
]

<br>
<br>
<br>
http://localhost:9091/flightsearch?sourceCity=chennai&destinationCity=delhi&travelDate=2020-05-17

<br>
<br>
<br>
<br>
[
  {
    "flight_no": "SJ01",
    "air_line": "Spice Jet",
    "depature_time": "2020-05-05 20:00",
    "arriavl_time": "2020-05-05 23:00",
    "price": 5000,
    "source_city": "chennai",
    "destination_city": "delhi",
    "travel_date": "2020-05-17",
    "return_date": "2020-06-20"
  },
  {
    "flight_no": "AI01",
    "air_line": "Air India",
    "depature_time": "2020-05-05 20:00",
    "arriavl_time": "2020-05-05 23:00",
    "price": 5000,
    "source_city": "chennai",
    "destination_city": "delhi",
    "travel_date": "2020-05-17",
    "return_date": "2020-06-20"
  }
]

 
 