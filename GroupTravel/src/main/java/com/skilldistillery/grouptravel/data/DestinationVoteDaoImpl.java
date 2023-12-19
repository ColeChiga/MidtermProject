package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Attendee;
import com.skilldistillery.grouptravel.entities.AttendeeId;
import com.skilldistillery.grouptravel.entities.DestinationVote;
import com.skilldistillery.grouptravel.entities.DestinationVoteId;
import com.skilldistillery.grouptravel.entities.VacationDestination;
import com.skilldistillery.grouptravel.entities.VacationDestinationId;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DestinationVoteDaoImpl implements DestinationVoteDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public DestinationVote create(boolean vote, String voteRemarks, int vacationId, int userId, int destinationId) {
		AttendeeId attendeeId = new AttendeeId(vacationId, userId);
		VacationDestinationId vacationDestinationId = new VacationDestinationId(vacationId, destinationId);
		Attendee attendee = em.find(Attendee.class, attendeeId);
		VacationDestination vacationDestination = em.find(VacationDestination.class, vacationDestinationId);
		DestinationVote destinationVote = new DestinationVote();
		DestinationVoteId destinationVoteId = new DestinationVoteId(vacationDestinationId, attendeeId);
		
		if (em.find(DestinationVote.class, destinationVoteId) == null) {
		destinationVote.setVote(vote);
		destinationVote.setVoteRemarks(voteRemarks);
		destinationVote.setAttendee(attendee);
		destinationVote.setDestination(vacationDestination);
			em.persist(destinationVote);
		} else {
			destinationVote = update(destinationVoteId, vote, voteRemarks);
		}

		return destinationVote;
	}

	@Override
	public DestinationVote update(DestinationVoteId id, boolean newVote, String newVoteRemarks) {
		DestinationVote destinationVote = em.find(DestinationVote.class, id);
		if (destinationVote != null) {
			destinationVote.setVote(newVote);
			destinationVote.setVoteRemarks(newVoteRemarks);
			em.merge(destinationVote);
			return destinationVote;
		}
		return null;
	}

	@Override
	public boolean deleteById(int destinationVoteId) {
		DestinationVote destinationVote = em.find(DestinationVote.class, destinationVoteId);
		if (destinationVote != null) {
			em.remove(destinationVote);
			return true;
		}
		return false;
	}

	@Override
	public List<DestinationVote> findVotesByAttendeeId(Attendee attendeeId) {
		String jpql = "SELECT vote FROM DestinationVote vote JOIN FETCH vote.attendee WHERE attendee.id = :attendeeId";
		return em.createQuery(jpql, DestinationVote.class).setParameter("attendeId", attendeeId).getResultList();
	}

}
