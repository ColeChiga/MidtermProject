package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.User;

public interface UserDAO {
	User authenticateUser(String username, String password);

	public List<Destination> findAll();

	User create(User user);

	User update(int userId, User user);

	boolean deleteById(int userId);

}
