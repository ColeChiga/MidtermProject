package com.skilldistillery.grouptravel.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class DestinationVoteId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Embedded
	private VacationDestinationId vacationDestinationId;

	@Embedded
	private AttendeeId attendeeId;

	public DestinationVoteId() {
		super();
	}

	public DestinationVoteId(VacationDestinationId vacationDestinationId, AttendeeId attendeeId) {
		super();
		this.vacationDestinationId = vacationDestinationId;
		this.attendeeId = attendeeId;
	}

	public VacationDestinationId getVacationDestinationId() {
		return vacationDestinationId;
	}

	public void setVacationDestinationId(VacationDestinationId vacationDestinationId) {
		this.vacationDestinationId = vacationDestinationId;
	}

	public AttendeeId getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(AttendeeId attendeeId) {
		this.attendeeId = attendeeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attendeeId, vacationDestinationId);
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
		return Objects.equals(attendeeId, other.attendeeId)
				&& Objects.equals(vacationDestinationId, other.vacationDestinationId);
	}

	@Override
	public String toString() {
		return "DestinationVoteId [vacationDestinationId=" + vacationDestinationId + ", attendeeId=" + attendeeId + "]";
	}
}
