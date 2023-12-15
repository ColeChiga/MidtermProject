package com.skilldistillery.grouptravel.data;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Attendee;
import com.skilldistillery.grouptravel.entities.AttendeeId;
import com.skilldistillery.grouptravel.entities.DestinationVote;
import com.skilldistillery.grouptravel.entities.Flight;
import com.skilldistillery.grouptravel.entities.User;
import com.skilldistillery.grouptravel.entities.Vacation;
import com.skilldistillery.grouptravel.entities.VacationComment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VacationCommentDaoImpl implements VacationCommentDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public VacationComment create(Vacation vacation, User user, String comments) {
		VacationComment vacationComments = new VacationComment();
			vacationComments.setComment(comments);
			vacationComments.setUser(user);
			vacationComments.setVacation(vacation);
			System.out.println(vacationComments.toString());

			em.persist(vacationComments);
			return vacationComments;
		
	
	}

	@Override
	public boolean deleteById(int vacationId) {
		VacationComment deleteVacationComment = em.find(VacationComment.class, vacationId);
		em.remove(deleteVacationComment);
		return false;
	}

}
