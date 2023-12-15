package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Attendee;
import com.skilldistillery.grouptravel.entities.AttendeeId;
import com.skilldistillery.grouptravel.entities.Flight;
import com.skilldistillery.grouptravel.entities.User;
import com.skilldistillery.grouptravel.entities.Vacation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightDAOImpl implements FlightDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Flight create(Flight flight, int userId, int vacationId) {
		em.find(Vacation.class, vacationId);
		em.find(User.class, userId);
		AttendeeId attendeeID = new AttendeeId(vacationId, userId);
		Attendee attendee = em.find(Attendee.class, attendeeID);
		if (attendee != null) {
			flight.setAttendee(attendee);
			em.persist(flight);
			return flight;
		}
		return null;
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

	@Override
	public Flight findFlightById(int flightId) {
		String jpql = "SELECT flight FROM Flight flight WHERE flight.id = :id";
		return em.createQuery(jpql, Flight.class).setParameter("flightId", flightId).getSingleResult();
	}

	@Override
	public List<Flight> findFlightByUserId(int userId) {
		String jpql = "SELECT flight FROM Flight flight JOIN FETCH flight.attendee WHERE attendee.user.id = :userId";
		return em.createQuery(jpql, Flight.class).setParameter("userId", userId).getResultList();
	}

}
