package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Location;
import com.skilldistillery.grouptravel.entities.LocationCategory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocationCategoryDaoImpl implements LocationCategoryDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<LocationCategory> findAll() {
		String jpql = "SELECT locationCategory FROM LocationCategory locationCategory";
        return em.createQuery(jpql, LocationCategory.class).getResultList();
	}

	@Override
	public LocationCategory findCategoryById(int categoryid) {
		return em.find(LocationCategory.class, categoryid);
	}

	@Override
	public LocationCategory create(LocationCategory locationCategory) {
		boolean test=false;
		String jpql = "SELECT locationCategory FROM LocationCategory locationCategory";
		List<LocationCategory> createLC = em.createQuery(jpql, LocationCategory.class).getResultList();
		for (LocationCategory lc : createLC) {
			if (lc.getName().equals(locationCategory.getName())) {
				test=true;
				lc.setDescription(locationCategory.getDescription());
				locationCategory=lc;
				
			}
				
		}
		
        if (!test) {
		em.persist(locationCategory);
        }
		return locationCategory;
	}

	@Override
	public LocationCategory update(LocationCategory locationCategory, int categoryId) {
		
		LocationCategory categoryFound = em.find(LocationCategory.class, categoryId);
		if (categoryFound != null) {
			categoryFound.setDescription(locationCategory.getDescription());
			categoryFound.setName(locationCategory.getName());
		}
		return categoryFound;
	}

	@Override
	public boolean delete(int categoryId) {
		
		
		return false;
	}

}
