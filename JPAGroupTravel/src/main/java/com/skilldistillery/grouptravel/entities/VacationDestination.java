package com.skilldistillery.grouptravel.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vacation_destination")
public class VacationDestination {

	@EmbeddedId
	private VacationDestinationId id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String remarks;

	@Column(name = "create_date")
	@CreationTimestamp
	private LocalDateTime createDate;

	@Column(name = "last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
//	@ManyToOne
//	@JoinColumn(name = "destination_id")
//	private Destination destination;

	@ManyToOne
	@JoinColumn(name = "destination_id")
	@MapsId(value = "destinationId")
	private Destination destination;

	@ManyToOne
	@JoinColumn(name = "vacation_id")
	@MapsId(value = "vacationId")
	private Vacation vacation;

	@OneToMany(mappedBy = "destination")
	private List<DestinationVote> destinationVotes;
	
	private boolean active;

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destinationId) {
		this.destination = destinationId;
	}

	public Vacation getVacation() {
		return vacation;
	}

	public void setVacation(Vacation vacationId) {
		this.vacation = vacationId;
	}

	public VacationDestinationId getId() {
		return id;
	}

	public void setId(VacationDestinationId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

//	public Destination getDestination() {
//		return destination;
//	}
//
//	public void setDestination(Destination destination) {
//		this.destination = destination;
//	}

	public List<DestinationVote> getDestinationVotes() {
		return destinationVotes;
	}

	public void setDestinationVotes(List<DestinationVote> destinationVotes) {
		this.destinationVotes = destinationVotes;
	}
	
	public int tallyDestinationVotes() {
		int voteYes = 0;
		for (DestinationVote votes :  destinationVotes ) {
			if(votes.getVote() == true) {
				voteYes++;
			}else {
				voteYes--;
			}
		}
		return voteYes;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createDate, id, lastUpdate, remarks, user);
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
		return Objects.equals(createDate, other.createDate) && Objects.equals(id, other.id)
				&& Objects.equals(lastUpdate, other.lastUpdate) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "VacationDestination [id=" + id + ", user=" + user + ", remarks=" + remarks + ", createDate="
				+ createDate + ", lastUpdate=" + lastUpdate + "]";
	}

	

}
