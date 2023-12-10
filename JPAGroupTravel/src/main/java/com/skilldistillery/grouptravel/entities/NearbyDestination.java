package com.skilldistillery.grouptravel.entities;
import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "nearby_destination")
public class NearbyDestination {

    @EmbeddedId
    private NearbyDestinationId id;
    
    @ManyToOne
	@JoinColumn(name = "destination_id") 
	@MapsId(value = "destinationId")     
	private Destination destinationId;
    @ManyToOne
    @JoinColumn(name = "nearby_id") 
    @MapsId(value = "nearbyId")     
    private Destination nearbyId;

	public NearbyDestinationId getId() {
		return id;
	}

	public void setId(NearbyDestinationId id) {
		this.id = id;
	}

	public Destination getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Destination destinationId) {
		this.destinationId = destinationId;
	}

	public Destination getNearbyId() {
		return nearbyId;
	}

	public void setNearbyId(Destination nearbyId) {
		this.nearbyId = nearbyId;
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
