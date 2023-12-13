package com.skilldistillery.grouptravel.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="vacation_comment")
public class VacationComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String comment;
	@Column(name="comment_date")
	private LocalDateTime commentDate;
	
	@ManyToOne
	@JoinColumn(name= "vacation_id")
	private Vacation vacation;
	@ManyToOne
	@JoinColumn(name= "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name= "reply_to_id")
	private VacationComment vacationComment;
	@OneToMany(mappedBy= "id")
	private List<VacationComment> reply;

	public VacationComment() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}

	public Vacation getVacation() {
		return vacation;
	}

	public void setVacation(Vacation vacation) {
		this.vacation = vacation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VacationComment getVacationComment() {
		return vacationComment;
	}

	public void setVacationComment(VacationComment vacationComment) {
		this.vacationComment = vacationComment;
	}

	public List<VacationComment> getReply() {
		return reply;
	}

	public void setReply(List<VacationComment> reply) {
		this.reply = reply;
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
		VacationComment other = (VacationComment) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "VacationComment [id=" + id + ", comment=" + comment + ", commentDate=" + commentDate + "]";
	}
	

}
