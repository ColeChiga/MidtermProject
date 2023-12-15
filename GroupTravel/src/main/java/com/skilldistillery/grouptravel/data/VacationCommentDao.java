package com.skilldistillery.grouptravel.data;

import com.skilldistillery.grouptravel.entities.User;
import com.skilldistillery.grouptravel.entities.Vacation;
import com.skilldistillery.grouptravel.entities.VacationComment;

public interface VacationCommentDao {

	VacationComment create(Vacation vacation, User user, String comments);
	
	
	boolean deleteById(int vacationId);
	
}
