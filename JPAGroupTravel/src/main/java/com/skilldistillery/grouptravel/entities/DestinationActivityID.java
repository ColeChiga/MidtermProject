package com.skilldistillery.grouptravel.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DestinationActivityID implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "destination_id")
	private int destinationId;
	@Column(name = "activity_id")
	private int activityId;
	
	public DestinationActivityID() {
	
	}

	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activityId, destinationId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DestinationActivityID other = (DestinationActivityID) obj;
		return activityId == other.activityId && destinationId == other.destinationId;
	}

	@Override
	public String toString() {
		return "DestinationActivityID [destinationId=" + destinationId + ", activityId=" + activityId + "]";
	}
	

}
