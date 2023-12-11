package com.skilldistillery.grouptravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private UserDAO userDao;

	@RequestMapping(path = "login.do", method = RequestMethod.GET)
	public String loginGet(HttpSession session) {
		if (session.getAttribute("sessionUser") != null) {
			return "home";

		}
		return "login";

	}
	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public String loginPost(User user, HttpSession session) {
		
		User loggedInUser = userDao.authenticateUser(user.getUsername(), user.getPassword());
		if (loggedInUser != null) {
			
			session.setAttribute("sessionUser", loggedInUser);
			return "account";
			
		}
		return "login";
		
	}

	
	
	
}
