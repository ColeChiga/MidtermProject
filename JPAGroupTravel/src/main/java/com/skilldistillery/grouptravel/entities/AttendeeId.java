package com.skilldistillery.grouptravel.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AttendeeId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "vacation_id")
    private int vacationId;

    @Column(name = "user_id")
    private int userId;

	public int getVacationId() {
		return vacationId;
	}

	public AttendeeId() {
		super();
	}

	public AttendeeId(int vacationId, int userId) {
		super();
		this.vacationId = vacationId;
		this.userId = userId;
	}

	public void setVacationId(int vacationId) {
		this.vacationId = vacationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, vacationId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttendeeId other = (AttendeeId) obj;
		return userId == other.userId && vacationId == other.vacationId;
	}

	@Override
	public String toString() {
		return "AttendeeId [vacationId=" + vacationId + ", userId=" + userId + "]";
	}

}
