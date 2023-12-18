package com.skilldistillery.grouptravel.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "estimated_cost")
	private String estimatedCost;
	@ManyToOne
	@JoinColumn(name ="destination_id")
	private Destination destination;
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;
	@ManyToOne
	@JoinColumn(name="location_category_id")
	private LocationCategory category;
	

	public Location() {
	}

	public LocationCategory getCategory() {
		return category;
	}

	public void setCategory(LocationCategory category) {
		category.addLocation(this);
		this.category = category;
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


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(String country) {
		this.estimatedCost = country;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination=destination;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
		Location other = (Location) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", estimatedCost=" + estimatedCost + "]";
	}

	


}
