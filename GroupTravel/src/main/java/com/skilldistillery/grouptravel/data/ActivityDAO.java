package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Activity;

public interface ActivityDAO {

	List<Activity> findActivityByDestinationId(int id);

	Activity findActivityId(int id);
	
	Activity create(Activity activity, int destinationId);

	Activity update(int activityId, Activity activity);

	boolean deleteById(int activityId, int destinationId);
	
}
