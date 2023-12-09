package com.skilldistillery.grouptravel.entities;
import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "nearby_destination")
public class NearbyDestination {

    @EmbeddedId
    private NearbyDestinationId id;

	public NearbyDestinationId getId() {
		return id;
	}

	public void setId(NearbyDestinationId id) {
		this.id = id;
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
		NearbyDestination other = (NearbyDestination) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "NearbyDestination [id=" + id + "]";
	}

    
}

