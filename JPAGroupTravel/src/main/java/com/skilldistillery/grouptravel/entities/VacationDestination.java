package com.skilldistillery.grouptravel.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="vacation_destination")
public class VacationDestination {
	
	
	private String remarks;
	@Column(name = "create_date")
	private LocalDateTime createDate;
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;

	public VacationDestination() {
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createDate, lastUpdate, remarks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VacationDestination other = (VacationDestination) obj;
		return Objects.equals(createDate, other.createDate) && Objects.equals(lastUpdate, other.lastUpdate)
				&& Objects.equals(remarks, other.remarks);
	}

	@Override
	public String toString() {
		return "VacationDestination [remarks=" + remarks + ", createDate=" + createDate + ", lastUpdate=" + lastUpdate
				+ "]";
	}
	

}
