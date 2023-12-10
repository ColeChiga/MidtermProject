package com.skilldistillery.grouptravel.entities;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "destination_vote")
public class DestinationVote {

    @EmbeddedId
    private DestinationVoteId id;

   
    private boolean vote;

    @Column(name = "vote_remarks")
    private String voteRemarks;

	public DestinationVoteId getId() {
		return id;
	}

	public void setId(DestinationVoteId id) {
		this.id = id;
	}

	public boolean getVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	public String getVoteRemarks() {
		return voteRemarks;
	}

	public void setVoteRemarks(String voteRemarks) {
		this.voteRemarks = voteRemarks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, vote, voteRemarks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DestinationVote other = (DestinationVote) obj;
		return Objects.equals(id, other.id) && vote == other.vote && Objects.equals(voteRemarks, other.voteRemarks);
	}

	@Override
	public String toString() {
		return "DestinationVote [id=" + id + ", vote=" + vote + ", voteRemarks=" + voteRemarks + "]";
	}

    
}

