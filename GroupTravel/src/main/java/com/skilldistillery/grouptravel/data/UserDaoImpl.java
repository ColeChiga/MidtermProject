package com.skilldistillery.grouptravel.data;

import org.springframework.stereotype.Service;

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
			user = em.createQuery(jpql, User.class).setParameter("username", username).setParameter("password", password).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid user: " + username);
		}
		return user;
	}
	
	
	
	
}
