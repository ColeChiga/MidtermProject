package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.Location;

public interface LocationDAO {

	List<Location> findAll();
	
	Location findLocationById(int locationid);

	Location create(Location location);
	
	Location update(Location location, int locationId, Destination destination);
	
	boolean delete(int locationId);


}
