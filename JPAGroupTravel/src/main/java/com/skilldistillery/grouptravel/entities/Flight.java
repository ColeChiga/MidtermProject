package com.skilldistillery.grouptravel.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String airline;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	@Column(name = "flight_number")
	private String flightNumber;
	private Boolean layover;
	@Column(name = "layover_airline")
	private String layoverAirline;
	@Column(name = "estimated_cost")
	private Double estimatedCost;
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "attendee_user_id", referencedColumnName = "user_id"),
			@JoinColumn(name = "attendee_vacation_id", referencedColumnName = "vacation_id") })
	private Attendee attendee;

	public Flight() {
	}

	public int getId() {
		return id;
	}

	public Attendee getAttendee() {
		return attendee;
	}

	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public LocalDateTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}

	public LocalDateTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Boolean isLayover() {
		return layover;
	}

	public void setLayover(Boolean layover) {
		this.layover = layover;
	}

	public String getLayoverAirline() {
		return layoverAirline;
	}

	public void setLayoverAirline(String layoverAirline) {
		this.layoverAirline = layoverAirline;
	}

	public Double getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", departure=" + departure + ", arrival=" + arrival
				+ ", flightNumber=" + flightNumber + ", layover=" + layover + ", layoverAirline=" + layoverAirline
				+ ", estimatedCost=" + estimatedCost + "]";
	}

}
