package com.skilldistillery.grouptravel.data;

import com.skilldistillery.grouptravel.entities.User;

public interface UserDAO {
	User authenticateUser(String username, String password);

}
