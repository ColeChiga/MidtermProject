package com.skilldistillery.grouptravel.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "desitnation_activity")
public class DestinationActivity {
	@EmbeddedId
	private DestinationActivityID id;
	
	
	public DestinationActivity() {
	
	}


	public DestinationActivityID getId() {
		return id;
	}


	public void setId(DestinationActivityID id) {
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
		DestinationActivity other = (DestinationActivity) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "DestinationActivity [id=" + id + "]";
	}
	

}
