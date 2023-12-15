package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.Vacation;

public interface DestinationDAO {

	List<Destination> findAll();
	
	Destination findDestinationById(int destinationId);

	Destination create(Destination destination);
	
	
}
