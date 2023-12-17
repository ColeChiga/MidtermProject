package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;


import com.skilldistillery.grouptravel.entities.Location;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocationDaoImpl implements LocationDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Location> findAll() {
		String jpql = "SELECT location FROM Location location";
        return em.createQuery(jpql, Location.class).getResultList();		
	}

	@Override
	public Location findLocationById(int locationId) {
		Location location = em.find(Location.class, locationId);
		return location;
	}

	@Override
	public Location create(Location location) {

		em.persist(location);
		return location;
	}

	@Override
	public Location update(Location location, int locationId) {
		Location locationFound = em.find(Location.class, locationId);
		if (locationFound != null) {
			locationFound.setAddress(location.getAddress());
			locationFound.setDescription(location.getDescription());
			locationFound.setDestination(location.getDestination());
			locationFound.setEstimatedCost(location.getEstimatedCost());
			locationFound.setImageUrl(location.getImageUrl());
			locationFound.setName(location.getName());
			locationFound.setCategory(location.getCategory());
		}
		return locationFound;
	}

	@Override
	public boolean delete(int locationId) {
		Location deletedLocation = em.find(Location.class, locationId);
		boolean successfullDeletedFam = false;
		if (deletedLocation != null) {
			em.remove(deletedLocation);
			
			successfullDeletedFam = true;
		}
		return successfullDeletedFam;
	}

}
