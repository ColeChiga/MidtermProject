package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Vacation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VacationDaoImpl implements VacationDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Vacation> findVacationByUserId(int id) {
		String jpql = "SELECT vacation FROM Vacation vacation JOIN FETCH vacation.user WHERE vacation.id = :id";

		return em.createQuery(jpql, Vacation.class).setParameter("id", id).getResultList();
	}

	@Override
	public Vacation findVacationById(int id) {
		String jpql = "Select vacation FROM Vacation vacation WHERE vacation.id = :id";
		return em.createQuery(jpql, Vacation.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Vacation create(Vacation vacation) {
		em.persist(vacation);
		vacation.setActive(true);
		return vacation;
	}

	@Override
	public Vacation update(int vacationId, Vacation vacation) {
		Vacation vacaFound = em.find(Vacation.class, vacationId);

		vacation.setActive(true);
		if (vacaFound != null) {
			vacaFound.setTitle(vacation.getTitle());
			vacaFound.setDescription(vacation.getDescription());
			vacaFound.setImageUrl(vacation.getImageUrl());
			vacaFound.setActive(vacation.isActive());
		}
		return vacaFound;
	}

	@Override
	public boolean deleteById(int vacationId) {
		Vacation deletedVaca = em.find(Vacation.class, vacationId);
		boolean successfullDeletedVaca = false;
		if (deletedVaca != null) {
			deletedVaca.setActive(successfullDeletedVaca);
			successfullDeletedVaca = !deletedVaca.isActive();
		}
		return successfullDeletedVaca;
	}

}
