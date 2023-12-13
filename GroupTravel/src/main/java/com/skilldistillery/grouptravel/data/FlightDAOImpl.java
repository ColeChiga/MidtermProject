package com.skilldistillery.grouptravel.data;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Flight;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightDAOImpl implements FlightDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Flight create(Flight flight) {
		em.persist(flight);
		return flight;
	}

	@Override
	public Flight update(int flightId, Flight flight) {
		Flight flightFound = em.find(Flight.class, flightId);

		if (flightFound != null) {
			flightFound.setAirline(flight.getAirline());
			flightFound.setDeparture(flight.getDeparture());
			flightFound.setArrival(flight.getArrival());
			flightFound.setFlightNumber(flight.getFlightNumber());
			flightFound.setLayoverAirline(flight.getLayoverAirline());
			flightFound.setEstimatedCost(flight.getEstimatedCost());
		}
		return flightFound;
	}

	@Override
	public boolean deleteById(int flightId) {
		Flight deletedFlight = em.find(Flight.class, flightId);
		boolean successfullDeletedFlight = false;
		if (deletedFlight != null) {
			em.remove(deletedFlight);
			successfullDeletedFlight = !em.contains(deletedFlight);
		}
		return successfullDeletedFlight;
	}

}
