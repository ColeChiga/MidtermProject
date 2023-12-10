package com.skilldistillery.grouptravel.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class VacationDestinationId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "vacation_id")
    private int vacationId;

    @Column(name = "destination_id")
    private int destinationId;

	public int getVacationId() {
		return vacationId;
	}

	public void setVacationId(int vacationId) {
		this.vacationId = vacationId;
	}

	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destinationId, vacationId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VacationDestinationId other = (VacationDestinationId) obj;
		return destinationId == other.destinationId && vacationId == other.vacationId;
	}

	@Override
	public String toString() {
		return "VacationDestinationId [vacationId=" + vacationId + ", destinationId=" + destinationId + "]";
	}

  
}
