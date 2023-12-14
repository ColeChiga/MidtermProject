package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Attendee;
import com.skilldistillery.grouptravel.entities.AttendeeId;
import com.skilldistillery.grouptravel.entities.User;
import com.skilldistillery.grouptravel.entities.Vacation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AttendeeDaoImpl implements AttendeeDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Vacation> findAll() {
		String jpql = "SELECT vacation FROM Vacation vacation";
		return em.createQuery(jpql, Vacation.class).getResultList();

	}

	@Override
	public Vacation findVacationById(int vacationId, int userId) {
		String jpql = "SELECT vacation FROM Vacation vacation JOIN FETCH vacation.attendee WHERE vacation.id = :vacationId and attendee.user = :userId";
		Vacation vacationSysOut = em.createQuery(jpql, Vacation.class).setParameter("vacationId", vacationId)
				.setParameter("attendee.user", userId).getSingleResult();
		System.out.println(vacationSysOut);
		return vacationSysOut;
	}

	@Override
	public Attendee create(Attendee attendee, int vacationId, int userId) {
		Vacation vacation = em.find(Vacation.class ,vacationId);
		User user = em.find(User.class, userId);
		if (vacation !=null && user !=null) {
			AttendeeId attendeeId = new AttendeeId(vacationId, userId);
			attendee.setId(attendeeId);
			attendee.setUser(user);
			attendee.setVacation(vacation);
			em.persist(attendee);
			return attendee;
		}
		return null;
	}

	@Override
	public Attendee update(int id, Attendee attendee) {
		Attendee attendeeFound = em.find(Attendee.class, id);
		attendee.setConfirmed(true);
		if (attendeeFound != null) {
			attendeeFound.setJoinDate(attendee.getJoinDate());
			attendeeFound.setRemarks(attendee.getRemarks());
			attendeeFound.setConfirmed(attendee.isConfirmed());
		}
		return attendeeFound;
	}

	@Override
	public boolean deleteById(int userId) {
		Attendee deletedAttendee = em.find(Attendee.class, userId);
		boolean successfullDeletedAttendee = false;
		if (deletedAttendee != null) {
			deletedAttendee.setConfirmed(false);
			successfullDeletedAttendee = !deletedAttendee.isConfirmed();
		}
		return successfullDeletedAttendee;
	}

}
