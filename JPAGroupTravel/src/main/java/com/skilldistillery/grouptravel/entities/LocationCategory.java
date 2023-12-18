package com.skilldistillery.grouptravel.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="location_category")
public class LocationCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "category")
	private List<Location> locations;


	public LocationCategory() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Location> getLocations() {
		return locations;
	}
	
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public void addLocation (Location location) {
		if (this.locations == null) {
			this.locations = new ArrayList<>();

		}
		if (!this.locations.contains(location)) {
			this.locations.add(location);
			location.setCategory(this);
		}
	}
	public void removeLocation(Location location) {
		if (this.locations!=null && this.locations.contains(location)) {
			this.locations.remove(location);
			location.setCategory(null);
		}
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
		LocationCategory other = (LocationCategory) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "LocationCategory [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	

}
