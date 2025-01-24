package com.skilldistillery.grouptravel.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private String street2;
	private String city;
	private String state;

	@Column(name = "postal_code")
	private String postalCode;
	@OneToMany(mappedBy = "address")
	private List<Location> location;
	@OneToMany(mappedBy = "address")
	private List<User> user;
	

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Address() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}
	
	public void addLocation(Location location) {
		if (this.location == null) {
			this.location = new ArrayList<>();

		}
		if (!this.location.contains(location)) {
			this.location.add(location);
			location.setAddress(this);
		}
	}
	public void removeLocation(Location location) {
		if (this.location!=null && this.location.contains(location)) {
			this.location.remove(location);
			location.setAddress(null);
		}
	}
	public void addUser(User user) {
		if (this.user == null) {
			this.user = new ArrayList<>();
			
		}
		if (!this.user.contains(user)) {
			this.user.add(user);
			user.setAddress(this);
		}
	}
	public void removeUser(User user) {
		if (this.user!=null && this.user.contains(user)) {
			this.user.remove(user);
			user.setAddress(null);
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
		Address other = (Address) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", street2=" + street2 + ", city=" + city + ", state="
				+ state + ", postalCode=" + postalCode + "]";
	}

}
