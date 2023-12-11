package com.skilldistillery.grouptravel.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "destination_vote")
public class DestinationVote {

	@EmbeddedId
	private DestinationVoteId id;

	private boolean vote;

	@Column(name = "vote_remarks")
	private String voteRemarks;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "attendee_vacation_id", referencedColumnName = "vacation_id"), @JoinColumn(name = "attendee_user_id",referencedColumnName = "user_id") })
	@MapsId(value="attendeeId")
	private Attendee attendee;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "destination_vacation_id", referencedColumnName = "vacation_id"), @JoinColumn(name = "destination_destination_id", referencedColumnName = "destination_id") })
	@MapsId(value="vacationDestinationId")
	private VacationDestination destination;

	public DestinationVoteId getId() {
		return id;
	}

	public void setId(DestinationVoteId id) {
		this.id = id;
	}

	public boolean getVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	public String getVoteRemarks() {
		return voteRemarks;
	}

	public void setVoteRemarks(String voteRemarks) {
		this.voteRemarks = voteRemarks;
	}

	public Attendee getAttendee() {
		return attendee;
	}

	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}

	public VacationDestination getDestination() {
		return destination;
	}

	public void setDestination(VacationDestination destination) {
		this.destination = destination;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, vote, voteRemarks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DestinationVote other = (DestinationVote) obj;
		return Objects.equals(id, other.id) && vote == other.vote && Objects.equals(voteRemarks, other.voteRemarks);
	}

	@Override
	public String toString() {
		return "DestinationVote [id=" + id + ", vote=" + vote + ", voteRemarks=" + voteRemarks + "]";
	}

}
