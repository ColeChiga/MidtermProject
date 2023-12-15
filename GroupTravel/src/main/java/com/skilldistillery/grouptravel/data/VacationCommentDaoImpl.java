package com.skilldistillery.grouptravel.data;

import org.springframework.stereotype.Service;

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
		//em.find(VacationComment.class, vacationComments);
			vacationComments.setComment(comments);
			vacationComments.setUser(user);
			vacationComments.setVacation(vacation);
			System.out.println(vacationComments.toString());

			em.persist(vacationComments);
			return vacationComments;
		
	
	}

	@Override
	public boolean deleteById(Vacation vacation) {
		VacationComment deletedVacationComment = em.find(VacationComment.class, vacation);
		boolean successfullDeletedVacationComment = false;
		if (deletedVacationComment != null) {
			em.remove(deletedVacationComment);
			successfullDeletedVacationComment = !em.contains(deletedVacationComment);
		}
		return successfullDeletedVacationComment;
	}

}
