package com.skilldistillery.grouptravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.skilldistillery.grouptravel.data.UserDAO;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;
	
}
