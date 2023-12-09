package com.skilldistillery.grouptravel.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;    
	private String airline;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	@Column(name="flight_number")
	private String flightNumber;
	private boolean layover;
	@Column(name="layover_airline")
	private String layoverAirline;
	@Column(name="estimated_cost")
	private double estimatedCost;
	

	public Flight() {
		// TODO Auto-generated constructor stub

	}


	public int getId() {
		return id;
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


	public boolean isLayover() {
		return layover;
	}


	public void setLayover(boolean layover) {
		this.layover = layover;
	}


	public String getLayoverAirline() {
		return layoverAirline;
	}


	public void setLayoverAirline(String layoverAirline) {
		this.layoverAirline = layoverAirline;
	}


	public double getEstimatedCost() {
		return estimatedCost;
	}


	public void setEstimatedCost(double estimatedCost) {
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
