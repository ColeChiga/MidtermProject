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
public class DestinationDaoImpl{

	@PersistenceContext
	private EntityManager em;


	public List<Destination> findAll() {
		String jpql = "SELECT destination FROM Destination destination";
        return em.createQuery(jpql, Destination.class).getResultList();
	
	}
	
	
	
	
}
