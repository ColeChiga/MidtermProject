package com.skilldistillery.grouptravel.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class NearbyDestinationId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "destination_id")
    private int destinationId;

    @Column(name = "nearby_id")
    private int nearbyId;

	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public int getNearbyId() {
		return nearbyId;
	}

	public void setNearbyId(int nearbyId) {
		this.nearbyId = nearbyId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destinationId, nearbyId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NearbyDestinationId other = (NearbyDestinationId) obj;
		return destinationId == other.destinationId && nearbyId == other.nearbyId;
	}

	@Override
	public String toString() {
		return "NearbyDestinationId [destinationId=" + destinationId + ", nearbyId=" + nearbyId + "]";
	}
    

}
