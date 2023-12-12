package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Address;
import com.skilldistillery.grouptravel.entities.Destination;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AddressDaoImpl implements AddressDao{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Destination> findAll() {
		String jpql = "SELECT destination FROM Destination destination";
		return em.createQuery(jpql, Destination.class).getResultList();

	}

	@Override
	public Destination findDestinationById(int destinationId) {
		return em.find(Destination.class, destinationId);
	}

	@Override
	public Address create(Address address) {
		em.persist(address);
		return address;
	}

}
