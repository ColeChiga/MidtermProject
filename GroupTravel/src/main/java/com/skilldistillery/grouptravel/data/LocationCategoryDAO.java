package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.Location;
import com.skilldistillery.grouptravel.entities.LocationCategory;

public interface LocationCategoryDAO {

	List<LocationCategory> findAll();
	
	LocationCategory findCategoryById(int categoryid);

	LocationCategory create(LocationCategory location);
	
	LocationCategory update(LocationCategory location, int locationId);
	
	boolean delete(int locationId);

}
