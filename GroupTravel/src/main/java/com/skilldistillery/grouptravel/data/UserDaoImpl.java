package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDaoImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User authenticateUser(String username, String password) {
		String jpql = "SELECT user FROM User user WHERE user.username = :username and user.password = :password and user.enabled = true";
		User user = null;
		try {
			user = em.createQuery(jpql, User.class).setParameter("username", username)
					.setParameter("password", password).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid user: " + username);
		}
		return user;
	}

	@Override
	public List<Destination> findAll() {
		String jpql = "SELECT destination FROM Destination destination";
		return em.createQuery(jpql, Destination.class).getResultList();

	}

	@Override
	public User create(User user) {
		em.persist(user);
		user.setEnabled(true);
		return user;
	}

	@Override
	public User update(int userId, User user) {
		User userFound = em.find(User.class, userId);
		user.setEnabled(true);
		if (userFound != null) {
			userFound.setFirstName(user.getFirstName());
			userFound.setLastName(user.getLastName());
			userFound.setUsername(user.getUsername());
			userFound.setPassword(user.getPassword());
			userFound.setRole(user.getRole());
			userFound.setEnabled(user.isEnabled());
			userFound.setImageUrl(user.getImageUrl());
			userFound.setCreateDate(user.getCreateDate());
			userFound.setLastUpdate(user.getLastUpdate());
			userFound.setAboutMe(user.getAboutMe());
			userFound.setFamilies(user.getFamilies());
			userFound.setVacations(user.getVacations());
			userFound.setEnabled(user.isEnabled());
		}
		return userFound;
	}

	@Override
	public boolean deleteById(int userId) {
		User deletedUser= em.find(User.class, userId);
		boolean successfullDeletedUser = false;
		if (deletedUser != null) {
			em.remove(deletedUser);
			successfullDeletedUser = !em.contains(deletedUser);
		}
		return successfullDeletedUser;
	}

}
