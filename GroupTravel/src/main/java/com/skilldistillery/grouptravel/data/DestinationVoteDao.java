package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Attendee;
import com.skilldistillery.grouptravel.entities.AttendeeId;
import com.skilldistillery.grouptravel.entities.DestinationVote;
import com.skilldistillery.grouptravel.entities.DestinationVoteId;
import com.skilldistillery.grouptravel.entities.Vacation;
import com.skilldistillery.grouptravel.entities.VacationDestination;

public interface DestinationVoteDao {

	DestinationVote update(DestinationVoteId id, boolean newVote, String newVoteRemarks);

	boolean deleteById(int destinationVoteId);

	DestinationVote create(boolean vote, String voteRemarks, int vacationId, int userId, int destinationId);

	public List<DestinationVote> findVotesByAttendeeId(Attendee attendeeId);

}
