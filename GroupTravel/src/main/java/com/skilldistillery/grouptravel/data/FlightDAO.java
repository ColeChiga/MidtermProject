package com.skilldistillery.grouptravel.data;

import com.skilldistillery.grouptravel.entities.Flight;

public interface FlightDAO {

	Flight create(Flight flight);

	Flight update(int flightId, Flight flight);

	boolean deleteById(int flightId);

}
