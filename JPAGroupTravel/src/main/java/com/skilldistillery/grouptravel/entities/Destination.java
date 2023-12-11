package com.skilldistillery.grouptravel.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column(name = "image_url")
	private String imageUrl;
	private String country;
	@ManyToMany(mappedBy = "destination")
	private List<Activity> activity;
	@OneToMany(mappedBy = "destination")
	private List<Location> location;
	@OneToMany(mappedBy = "destinationId")
	private List<VacationDestination> vacationDestination;
	@OneToMany(mappedBy = "destinationId")
	private List<NearbyDestination> nearbyDestination;

	public Destination() {
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Activity> getActivity() {
		return activity;
	}

	public void setActivity(List<Activity> activity) {
		this.activity = activity;
	}

	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}

	public List<VacationDestination> getVacationDestination() {
		return vacationDestination;
	}

	public void setVacationDestination(List<VacationDestination> vacationDestination) {
		this.vacationDestination = vacationDestination;
	}

	public List<NearbyDestination> getNearbyDestination() {
		return nearbyDestination;
	}

	public void setNearbyDestination(List<NearbyDestination> nearbyDestination) {
		this.nearbyDestination = nearbyDestination;
	}

	public void addActivity(Activity activity) {
		if (this.activity == null) {
			this.activity = new ArrayList<>();

		}
		if (!this.activity.contains(activity)) {
			this.activity.add(activity);
			activity.addDestination(this);
		}

	}

	public void removeActivity(Activity activity) {
		if (this.activity != null && this.activity.contains(activity)) {
			this.activity.remove(activity);
			activity.removeDestination(this);
		}

	}

	public void addLocation(Location location) {
		if (this.location == null) {
			this.location = new ArrayList<>();

		}
		if (!this.location.contains(location)) {
			this.location.add(location);
			location.setDestination(this);
		}

	}

	public void removeLocation(Location location) {
		if (this.location != null && this.location.contains(location)) {
			this.location.remove(location);
			location.setDestination(null);
		}
	}

	public void addVacationDestination(VacationDestination vacationDestination) {
		if (this.vacationDestination == null) {
			this.vacationDestination = new ArrayList<>();

		}
		if (!this.vacationDestination.contains(vacationDestination)) {
			this.vacationDestination.add(vacationDestination);
			vacationDestination.setDestinationId(this);
		}

	}

	public void removeVacationDestination(VacationDestination vacationDestination) {
		if (this.vacationDestination != null && this.vacationDestination.contains(vacationDestination)) {
			this.vacationDestination.remove(vacationDestination);
			vacationDestination.setDestinationId(null);
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
		Destination other = (Destination) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", country=" + country + "]";
	}

	

}