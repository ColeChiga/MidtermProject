package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Family;
import com.skilldistillery.grouptravel.entities.User;

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
		family.setEnabled(true);
		return family;
	}

	@Override
	public Family update(int familyId, Family family, User user) {
		Family famFound = em.find(Family.class, familyId);
		user = em.find(User.class, user.getId());
		family.setEnabled(true);
		if (famFound != null) {
			famFound.addUser(user);
			famFound.setName(family.getName());
			famFound.setDescription(family.getDescription());
			famFound.setImageUrl(family.getImageUrl());
			famFound.setEnabled(family.isEnabled());

		}
		return famFound;
	}

	@Override
	public boolean deleteById(int familyId) {
		Family deletedFam = em.find(Family.class, familyId);
		boolean successfullDeletedFam = false;
		if (deletedFam != null) {
			deletedFam.setEnabled(false);
			successfullDeletedFam = !deletedFam.isEnabled();
		}
		return successfullDeletedFam;
	}
	
	@Override
	public List<Family> findAll() {
		String jpql = "SELECT family FROM Family family";
        return em.createQuery(jpql, Family.class).getResultList();
	}

}
