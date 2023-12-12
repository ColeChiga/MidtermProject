package com.skilldistillery.grouptravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.grouptravel.data.AddressDao;
import com.skilldistillery.grouptravel.data.AddressDaoImpl;
import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.entities.Address;
import com.skilldistillery.grouptravel.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;
	@Autowired
	private AddressDao addressDao;
	
	@RequestMapping(path = {"/", "home.do"} )
	public String home(Model model) {
		model.addAttribute("SMOKETEST", userDao.authenticateUser("admin", "12345"));
		return "home";
		
	}
	
	@RequestMapping(path="createAccount.do", method = RequestMethod.POST)
	public String createAccount(HttpSession session, User user, Address address) {
		Address createAddress = addressDao.create(address);
		session.setAttribute("sessionAddress", createAddress);
		user.setAddress(createAddress);
		User createUser= userDao.create(user);
		session.setAttribute("sessionUser", createUser);
		if(createUser == null) {
			return "createAccount";
		}
		else {
			return "account";
		}
		
		
		
		
	}
	
}
