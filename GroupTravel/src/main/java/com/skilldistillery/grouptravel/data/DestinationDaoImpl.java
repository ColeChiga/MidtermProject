package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.User;
import com.skilldistillery.grouptravel.entities.Vacation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DestinationDaoImpl implements DestinationDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Destination> findAll() {
		String jpql = "SELECT destination FROM Destination destination";
        return em.createQuery(jpql, Destination.class).getResultList();
	
	}
	
	@Override
	public Destination findDestinationById(int destinationId){
		return em.find(Destination.class, destinationId);
	}

	@Override
	public Destination create(Destination destination) {
		em.persist(destination);
		return destination;
	}
	
	
	
	
}
