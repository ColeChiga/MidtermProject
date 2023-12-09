package com.skilldistillery.grouptravel.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_family")
public class UserFamily {
	
	@EmbeddedId
	private UserFamilyID id;

	public UserFamily() {
	}

	public UserFamilyID getId() {
		return id;
	}

	public void setId(UserFamilyID id) {
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
		UserFamily other = (UserFamily) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "UserFamily [id=" + id + "]";
	}

}
