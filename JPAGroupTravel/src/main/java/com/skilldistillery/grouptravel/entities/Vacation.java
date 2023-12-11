package com.skilldistillery.grouptravel.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Vacation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "create_date")
	private LocalDateTime createDate;
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;

	@OneToMany(mappedBy = "vacation")
	private List<VacationDestination> destinations;

	public Vacation() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public List<VacationDestination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<VacationDestination> destinations) {
		this.destinations = destinations;
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
		Vacation other = (Vacation) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Vacation [id=" + id + ", title=" + title + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", createDate=" + createDate + ", lastUpdate=" + lastUpdate + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}
