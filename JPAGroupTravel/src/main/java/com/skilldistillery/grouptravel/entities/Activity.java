package com.skilldistillery.grouptravel.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column(name = "estimated_time_hours")
	private Double estimatedTimeInHours;
	@Column(name = "estimated_cost")
	private Double estimatedCost;
	@ManyToMany
	@JoinTable(name = "destination_activity", joinColumns = @JoinColumn(name = "activity_id"), inverseJoinColumns = @JoinColumn(name = "destination_id"))
	private List<Destination> destination;

	public Activity() {
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

	public Double getEstimatedTimeInHours() {
		return estimatedTimeInHours;
	}

	public void setEstimatedTimeInHours(Double estimatedTimeInHours) {
		this.estimatedTimeInHours = estimatedTimeInHours;
	}

	public Double getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public List<Destination> getDestination() {
		return destination;
	}

	public void setDestination(List<Destination> destination) {
		this.destination = destination;
	}

	public void addDestination(Destination destination) {
		if (this.destination == null) {
			this.destination = new ArrayList<>();

		}
		if (!this.destination.contains(destination)) {
			this.destination.add(destination);
			destination.addActivity(this);
		}
	}
	public void removeDestination(Destination destination) {
		if (this.destination!=null && this.destination.contains(destination)) {
			this.destination.remove(destination);
			destination.removeActivity(this);
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
		Activity other = (Activity) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", description=" + description + ", estimatedTimeInHours="
				+ estimatedTimeInHours + ", estimatedCost=" + estimatedCost + ", destination=" + destination + "]";
	}

}
