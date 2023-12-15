package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Flight;

public interface FlightDAO {

	Flight findFlightById(int flightId);

	List<Flight> findFlightByUserId(int flightId);

	Flight create(Flight flight,int userId, int vacationId);

	Flight update(int flightId, Flight flight);

	boolean deleteById(int flightId);

}
