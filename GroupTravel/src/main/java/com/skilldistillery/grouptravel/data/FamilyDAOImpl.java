package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Family;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FamilyDAOImpl implements FamilyDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Family> findFamilyByUserId(int id) {
		String jpql = "SELECT family FROM Family family JOIN FETCH family.users WHERE family.id = :id";

		return em.createQuery(jpql, Family.class).setParameter("id", id).getResultList();
	}

	@Override
	public Family create(Family family) {
		em.persist(family);
		return null;
	}

	@Override
	public Family update(int familyId, Family family) {
		Family famFound = em.find(Family.class, familyId);

		if (famFound != null) {
			famFound.setName(family.getName());
			famFound.setDescription(family.getDescription());
			famFound.setImageUrl(family.getImageUrl());

		}
		return famFound;
	}

	@Override
	public boolean deleteById(int familyId) {
		Family deletedFam = em.find(Family.class, familyId);
		boolean successfullDeletedFam = false;
		if (deletedFam != null) {
			em.remove(deletedFam);
			successfullDeletedFam = !em.contains(deletedFam);
		}
		return successfullDeletedFam;
	}

}
