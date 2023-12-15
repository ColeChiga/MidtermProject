package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.User;
import com.skilldistillery.grouptravel.entities.Vacation;
import com.skilldistillery.grouptravel.entities.VacationDestination;

public interface VacationDestinationDAO {

	List<Destination> findAll();
	
	VacationDestination findVacationDestinationById(int destinationId);


	VacationDestination create(Vacation vacation, Destination destination, User user, String remarks);

	List<VacationDestination >findVacationDestinationByVacationId(int id);
	
	
}
