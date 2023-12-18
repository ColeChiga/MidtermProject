package com.skilldistillery.grouptravel.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.grouptravel.entities.Activity;
import com.skilldistillery.grouptravel.entities.Destination;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ActivityDAOImpl implements ActivityDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Activity> findActivityByDestinationId(int id) {
		String jpql = "SELECT destination.activity FROM Destination destination WHERE destination.id = :id";
		return em.createQuery(jpql, Activity.class).setParameter("id", id).getResultList();
	}

	@Override
	public Activity findActivityId(int id) {
		String jpql = "SELECT activity FROM Activity activity WHERE activity.id = :id";

		return em.createQuery(jpql, Activity.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Activity create(Activity activity, int destinationId) {
		Destination destination = em.find(Destination.class, destinationId);
		if (activity != null) {
			destination.addActivity(activity);
			em.persist(activity);
			return activity;
		}
		return null;
	}

	@Override
	public Activity update(int activityId, Activity activity) {
		Activity actFound = em.find(Activity.class, activityId);
		if (actFound != null) {
			actFound.setName(activity.getName());
			actFound.setDescription(activity.getDescription());
			actFound.setEstimatedTimeInHours(activity.getEstimatedTimeInHours());
			actFound.setEstimatedCost(activity.getEstimatedCost());
		}

		return actFound;
	}

	@Override
	public boolean deleteById(int activityId, int destinationId) {

		Activity deleteActivity = em.find(Activity.class, activityId);
		Destination destination = em.find(Destination.class, destinationId);

		boolean success = false;
		if (deleteActivity != null) {
			destination.removeActivity(deleteActivity);
			em.remove(deleteActivity);
			success = true;
		}
		return success;
	}

}
