package com.skilldistillery.grouptravel.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DestinationVoteId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "attendee_vacation_id")
    private int attendeeVacationId;

    @Column(name = "attendee_user_id")
    private int attendeeUserId;

    @Column(name = "destination_vacation_id")
    private int destinationVacationId;

    @Column(name = "destination_destination_id")
    private int destinationDestinationId;

	public int getAttendeeVacationId() {
		return attendeeVacationId;
	}

	public void setAttendeeVacationId(int attendeeVacationId) {
		this.attendeeVacationId = attendeeVacationId;
	}

	public int getAttendeeUserId() {
		return attendeeUserId;
	}

	public void setAttendeeUserId(int attendeeUserId) {
		this.attendeeUserId = attendeeUserId;
	}

	public int getDestinationVacationId() {
		return destinationVacationId;
	}

	public void setDestinationVacationId(int destinationVacationId) {
		this.destinationVacationId = destinationVacationId;
	}

	public int getDestinationDestinationId() {
		return destinationDestinationId;
	}

	public void setDestinationDestinationId(int destinationDestinationId) {
		this.destinationDestinationId = destinationDestinationId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attendeeUserId, attendeeVacationId, destinationDestinationId, destinationVacationId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DestinationVoteId other = (DestinationVoteId) obj;
		return attendeeUserId == other.attendeeUserId && attendeeVacationId == other.attendeeVacationId
				&& destinationDestinationId == other.destinationDestinationId
				&& destinationVacationId == other.destinationVacationId;
	}

	@Override
	public String toString() {
		return "DestinationVoteId [attendeeVacationId=" + attendeeVacationId + ", attendeeUserId=" + attendeeUserId
				+ ", destinationVacationId=" + destinationVacationId + ", destinationDestinationId="
				+ destinationDestinationId + "]";
	}

    
}
