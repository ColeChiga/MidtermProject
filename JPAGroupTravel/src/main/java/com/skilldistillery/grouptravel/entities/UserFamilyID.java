package com.skilldistillery.grouptravel.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserFamilyID {

	private static final long serialVersionUID = 1L;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "family_id")
	private int familyId;
	public UserFamilyID() {
	
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(familyId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFamilyID other = (UserFamilyID) obj;
		return familyId == other.familyId && userId == other.userId;
	}
	@Override
	public String toString() {
		return "UserFamilyID [userId=" + userId + ", familyId=" + familyId + "]";
	}
	

}
