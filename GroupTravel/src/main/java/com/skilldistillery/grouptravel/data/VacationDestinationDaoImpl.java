package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Attendee;
import com.skilldistillery.grouptravel.entities.AttendeeId;
import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.DestinationVote;
import com.skilldistillery.grouptravel.entities.Flight;
import com.skilldistillery.grouptravel.entities.User;
import com.skilldistillery.grouptravel.entities.Vacation;
import com.skilldistillery.grouptravel.entities.VacationDestination;
import com.skilldistillery.grouptravel.entities.VacationDestinationId;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VacationDestinationDaoImpl implements VacationDestinationDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Destination> findAll() {
		String jpql = "SELECT vacationDestination FROM VacationDestination vacationDestination";
		return em.createQuery(jpql, Destination.class).getResultList();

	}

	@Override
	public VacationDestination findVacationDestinationById(int id) {
		return em.find(VacationDestination.class, id);
	}
	@Override
	public List<VacationDestination> findVacationDestinationByVacationId(int id) {
		String jpql = "SELECT vacationDestination FROM VacationDestination vacationDestination WHERE vacationDestination.vacation.id = :id";

		return em.createQuery(jpql, VacationDestination.class).setParameter("id",id).getResultList();
	}

	@Override
	public VacationDestination create(Vacation vacation, Destination destination, User user, String remarks) {
		
		
		
		VacationDestinationId vdi = new VacationDestinationId(vacation.getId(), destination.getId());
		VacationDestination newDestination = em.find(VacationDestination.class, vdi);
		if ( newDestination == null) {
			VacationDestination vd = new VacationDestination();
			vd.setId(vdi);
			vd.setActive(true);
			vd.setDestination(destination);
			vd.setRemarks(remarks);
			vd.setUser(user);
			vd.setVacation(vacation);
			System.out.println(vd.toString());

			em.persist(vd);
			return vd;
		}
		else{ 
			newDestination.setActive(true);
			newDestination.setRemarks(remarks);
		}
		return newDestination;
	}

	@Override
	public boolean deleteById(int destinationId, int vacationId) {
		VacationDestinationId vdi = new VacationDestinationId(vacationId, destinationId);

		Destination destination = em.find(Destination.class, destinationId);
 		VacationDestination deletedVD = em.find(VacationDestination.class, vdi);
		
		boolean successfullDeletedAttendee = false;
		if (deletedVD != null) {
			deletedVD.setActive(false);
			successfullDeletedAttendee = true;
		}

		return successfullDeletedAttendee;		
	}

}
