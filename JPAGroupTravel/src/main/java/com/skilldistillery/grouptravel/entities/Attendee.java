package com.skilldistillery.grouptravel.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendee")
public class Attendee {

	@EmbeddedId
	private AttendeeId id;

	@Column(name = "join_date")
	private LocalDateTime joinDate;

	private boolean confirmed;

	private String remarks;

	@ManyToOne
	@JoinColumn(name = "vacation_id")
	@MapsId(value = "vacationId")
	private Vacation vacation;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@MapsId(value = "userId")
	private User user;

	@OneToMany(mappedBy = "attendee")
	private List<DestinationVote> destinationVotes;

	@OneToMany(mappedBy = "attendee")
	private List<Flight> flights;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Location location;

	public AttendeeId getId() {
		return id;
	}

	public void setId(AttendeeId id) {
		this.id = id;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Vacation getVacation() {
		return vacation;
	}

	public void setVacation(Vacation vacation) {
		this.vacation = vacation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<DestinationVote> getDestinationVotes() {
		return destinationVotes;
	}

	public void setDestinationVotes(List<DestinationVote> destinationVotes) {
		this.destinationVotes = destinationVotes;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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
		Attendee other = (Attendee) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Attendee [id=" + id + ", joinDate=" + joinDate + ", confirmed=" + confirmed + ", remarks=" + remarks
				+ ", vacation=" + vacation + ", user=" + user + ", destinationVotes=" + destinationVotes + ", flights="
				+ flights + ", location=" + location + "]";
	}

}
